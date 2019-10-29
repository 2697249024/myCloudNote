package com.lyy.note.controller;


import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lyy.note.entity.ArticlePageHelperParam;
import com.lyy.note.entity.pojo.ArticleTitle;
import com.lyy.note.entity.pojo.ShowArticle;
import com.lyy.note.entity.vo.TagResultVo;
import com.lyy.note.exception.ActualException;
import com.lyy.note.service.IndexArticleService;
import com.lyy.note.service.impl.IndexArticleServiceImpl;
import com.lyy.note.service.impl.NoticeServiceImpl;
import com.lyy.note.util.PageHelper;
import com.lyy.note.vo.ResponseDTO;
/***
 * 文章控制层
 * @author 80004198
 *
 */
@RestController
public class articleController {
	@Autowired
	IndexArticleService indexArticleService;
	
	@Autowired
	IndexArticleServiceImpl indexArticleServiceImpl;
	
	@Resource
	RedisTemplate<String, List<TagResultVo>> redisTemplate;
	
	private static final Logger logger =LoggerFactory.getLogger(NoticeServiceImpl.class);
	
	/***
	 *  添加文章内容
	 * @param editorTitle 标题
	 * @param editorIntro 简介
	 * @param editorTag 标签
	 * @param editorPicture 配图url
	 * @param editorDetails 主题内容
	 * @return ResponseDTO
	 */
	@CrossOrigin //允许跨域请求
    @RequestMapping(value = "/addArticleEditor",method = RequestMethod.POST)
    public ResponseDTO<String> addArticleEditor(String editorTitle,String editorIntro,
    		String editorTag, String editorPicture,String editorDetails){
		try {
			Boolean resultOfInseryArticle = indexArticleService.resultOfInseryArticle(editorTitle, editorIntro, editorTag, editorPicture, editorDetails);
			if(resultOfInseryArticle) {
				return ResponseDTO.buildSuccess("更新成功");
			}
		} catch (Exception e) {
			logger.error("-->addArticleEditor 插入文章异常");
			e.printStackTrace();
		}
	
		return ResponseDTO.buildFailure("网络异常啦");
	}	
	/***
	 * 查询首页文章信息
	 * @param id 为文章id 为空时表示查询全部
	 */
	@CrossOrigin
	@RequestMapping(value = "/showAticle",method = RequestMethod.POST)
	public ResponseDTO<List<ShowArticle>> showAticle(String id) {
		List<ShowArticle> selectIndexArtilce = indexArticleService.selectIndexArtilce(id);
		if(selectIndexArtilce.isEmpty()) {
			return ResponseDTO.buildFailure("接口异常");
		}
		return ResponseDTO.buildSuccess(selectIndexArtilce);
	}
	/***
	 *  分页查询笔记列表
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "/selecArtilceByPageHelper",method = RequestMethod.POST)
	public ResponseDTO<PageHelper<ShowArticle>> selecArtilceByPageHelper(Integer currentPage,Integer pageSize,String tags){
		//currentPage-1 即为当前传入数据库的当前页
		currentPage =currentPage-1;
		try {
			tags = java.net.URLDecoder.decode(tags, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ArticlePageHelperParam articlePageHelperParam = new ArticlePageHelperParam();
		articlePageHelperParam.setCurrentPage(currentPage);
		articlePageHelperParam.setPageSize(pageSize);
		articlePageHelperParam.setTags(tags);
		List<ShowArticle> selecArtilceByPageHelper = indexArticleService.selecArtilceByPageHelper(articlePageHelperParam);
		//获取笔记总数
		Integer selectCountArticle = indexArticleService.selectCountArticle(tags);
		//放入pageHelper 中
		PageHelper<ShowArticle> pageHelper = new PageHelper<ShowArticle>(currentPage, pageSize, selectCountArticle, selecArtilceByPageHelper);
		if(selecArtilceByPageHelper.isEmpty()) {
			logger.debug("selecArtilceByPageHelper--->查询结果为null");
			return ResponseDTO.buildFailure("查询分页失败");
		}
		return ResponseDTO.buildSuccess(pageHelper);
	}
	/***
	 *  查询笔记总数
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "/selectCountArticle",method = RequestMethod.POST)
	public ResponseDTO<Integer> selectCountArticle(String tags){
		//currentPage-1 即为当前传入数据库的当前页
		try {
			tags = java.net.URLDecoder.decode(tags, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Integer selectCountArticle = indexArticleService.selectCountArticle(tags);
		return ResponseDTO.buildSuccess(selectCountArticle);
	}
	
	/***
	 *  根据日期排序查询前12条文章标题
	 */
	@CrossOrigin
	@RequestMapping(value = "/selectArticleTitle",method = RequestMethod.POST)
	public ResponseDTO<List<ArticleTitle>> selectArticleTitle() {
		List<ArticleTitle> selectArticleTitle = indexArticleService.selectArticleTitle();
		if(selectArticleTitle.isEmpty()) {
			return ResponseDTO.buildFailure("接口异常");
		}
		return ResponseDTO.buildSuccess(selectArticleTitle);
	}
	
	//TODO 热门标签
	/***
	 * 查找热门标签
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "/selectHotLabels",method = RequestMethod.POST)
	public ResponseDTO<List<TagResultVo>> selectHotLabels() {
		try {
			//首次查询redis 并设置过期时间
			if(redisTemplate.opsForValue().get("tags")==null) {
				List<TagResultVo> selectHotLabels = indexArticleServiceImpl.selectHotLabels();
				redisTemplate.opsForValue().set("tags", selectHotLabels, 5, TimeUnit.MINUTES);
				logger.info("热门标签放入缓存过期时间：5min");
				return ResponseDTO.buildSuccess(selectHotLabels);
			}
			//从redis中获取
			List<TagResultVo> selectHotLabels = redisTemplate.opsForValue().get("tags");
			return ResponseDTO.buildSuccess(selectHotLabels);
		} catch (Exception e) {
			logger.error("selectHotLabels-->[热门标签计算异常]",e);
			if(e instanceof ActualException) {
				return ResponseDTO.buildFailure(e.getMessage());
			}
			return ResponseDTO.buildFailure("热门标签计算异常");
		}
	}
	
}
