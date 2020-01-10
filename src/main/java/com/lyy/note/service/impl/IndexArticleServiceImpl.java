package com.lyy.note.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.lyy.note.dao.ShowArticleMapper;
import com.lyy.note.entity.ArticlePageHelperParam;
import com.lyy.note.entity.Content;
import com.lyy.note.entity.Tag;
import com.lyy.note.entity.pojo.ArticleInsertPojo;
import com.lyy.note.entity.pojo.ArticleTitle;
import com.lyy.note.entity.pojo.ShowArticle;
import com.lyy.note.entity.vo.SearchResultVo;
import com.lyy.note.entity.vo.TagResultVo;
import com.lyy.note.exception.ActualException;
import com.lyy.note.service.IndexArticleService;
import com.lyy.note.util.GetTimeUtil;
import com.lyy.note.util.StringChackUtils;

@Service
@Transactional
public class IndexArticleServiceImpl implements IndexArticleService {
	
	private static final Logger log = LoggerFactory.getLogger(IndexArticleServiceImpl.class);
	
	@Autowired
	ShowArticleMapper showArticleMapper;
	
	@Override
	public List<ShowArticle> selectIndexArtilce(String id) {
		List<ShowArticle> selectIndexArtilce = showArticleMapper.selectIndexArtilce(id);
		return selectIndexArtilce;
	}
	@Override
	public List<ArticleTitle> selectArticleTitle() {
		List<ArticleTitle> selectArticleTitle = showArticleMapper.selectArticleTitle();
		return selectArticleTitle;
	}
	/***
	 * 更新文章内容
	 */
	@Override
	public Boolean insertArticle(ArticleInsertPojo articleInsertPojo) {
		Boolean insertArticle = showArticleMapper.insertArticle(articleInsertPojo);
		return insertArticle;
	}
	/**
	 * 文章分页查询
	 */
	@Override
	public List<ShowArticle> selecArtilceByPageHelper(ArticlePageHelperParam articlePageHelperParam) {
		try {
			List<ShowArticle> selecArtilceByPageHelper = showArticleMapper.selecArtilceByPageHelper(articlePageHelperParam);
			log.info("文章分页查询成功");
			return selecArtilceByPageHelper;
		} catch (Exception e) {
			log.error(" 文章分页查询错误", e);
		}
		return null;
	}
	/**
	 * 统计笔记总数
	 * @return 总笔记数
	 */
	@Override
	public Integer selectCountArticle(String tags) {
		Integer selectCountArticle = showArticleMapper.selectCountArticle(tags);
		return selectCountArticle;
	}
	
	/***
	 * 更新标签内容
	 */
	@Override
	public Boolean insertTag(Tag tag) {
		Boolean insertTag = showArticleMapper.insertTag(tag);
		return insertTag;
	}
	/**
	 * 更新详情内容
	 */
	@Override
	public Boolean insertContent(Content content) {
		Boolean insertContent = showArticleMapper.insertContent(content);
		return insertContent;
	}
	/***
	 * 最终是否更新成功
	 */
	@Override
	public Boolean resultOfInseryArticle(String editorTitle, String editorIntro, String editorTag, String editorPicture,
			String editorDetails) {
			//获取id
			 String uuid = UUID.randomUUID().toString().replaceAll("-","");
			//插入Article文章表
			ArticleInsertPojo articleInsertPojo =new ArticleInsertPojo();
			//文章id
			articleInsertPojo.setId(uuid);
			//插入用户id 目前默认为1 forever
			articleInsertPojo.setPostedId(1);
			//插入日期即为当前时间
			Date nowTime = GetTimeUtil.getNowTime();
			log.info("当前时间：[{}]",nowTime);
			articleInsertPojo.setArticleCreateDate(nowTime);
			//标签id
			articleInsertPojo.setArticleTagId(uuid);
			//文章详情id
			articleInsertPojo.setArticleContentId(uuid);
			//标题 ,头, 图片
			articleInsertPojo.setArticleTitle(editorTitle);
			articleInsertPojo.setArticleIntro(editorIntro);
			articleInsertPojo.setArticlePicture(editorPicture);
			//插入阅读数，新增文章阅读数为0 readingQuantity
			articleInsertPojo.setReadingQuantity(0);
			//-------------插入标签id和标签内容------------
			Tag tag = new Tag();
			//根据逗号拆分标签字符串
			String[] theTag = editorTag.split(",");
			for (int i = 0; i < theTag.length; i++) {
				if(i==0) {
					String tag1 = theTag[i];
					tag.setTag1(tag1);
				}else if(i==1){
					String tag2 = theTag[i];
					tag.setTag2(tag2);
				}else if (i==2) {
					String tag3 = theTag[i];
					tag.setTag3(tag3);
				}
			}
			tag.setTagId(uuid);
			Boolean insertTag = insertTag(tag);
			//--------插入content详情表-------------------------
			Content content = new Content();
			content.setContentId(uuid);
			content.setDetial(editorDetails);
			Boolean insertContent = insertContent(content);
			//如果标签 与 详情表均插入成功 则插入文章
			if(insertTag == true && insertContent == true) {
				//更新文章内容
				Boolean insertArticle = insertArticle(articleInsertPojo);
				if(insertArticle) {
					System.out.println("文章更新成功！");
					return true;
				}else {
					System.out.println("更新失败");
					return false;
				}
			}
		return false;
	}
	
	/***
	 * 获取热门标签
	 * @throws ActualException 
	 */
	@Override
	public List<TagResultVo> selectHotLabels() throws ActualException {
		//获取所有标签
		List<Tag> allLabels = showArticleMapper.selectAllLabels();
		if(allLabels.size()==0) {
			throw new ActualException("未获取标签信息，请检查网络后重试！"); 
		}
		List<String> tagList = new ArrayList<>();
		
		//处理标签
		allLabels.forEach(p ->{
			String tag1 = p.getTag1();
			String tag2 = p.getTag2();
			String tag3 = p.getTag3();
			try {
				String ne1 = StringChackUtils.nesgame(tag1);
				String ne2 = StringChackUtils.nesgame(tag2);
				String ne3 = StringChackUtils.nesgame(tag3);
				if(!StringUtils.isEmpty(ne1)) {
					tagList.add(ne1);
				}
				if(!StringUtils.isEmpty(ne2)) {
					tagList.add(ne2);
				}
				if(!StringUtils.isEmpty(ne3)) {
					tagList.add(ne3);
				}	
			} catch (ActualException e) {
				log.error("获取热门标签异常", e);
			}
		});
		
		//筛选
		List<TagResultVo> list;
		try {
			list = new ArrayList<>();
			//按出现次数从大到小排序 筛选出出现次数最多的前16个字符串 
			tagList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).forEach( (key, value)->{
				TagResultVo a= new TagResultVo(); a.name = key; a.count = value; list.add(a);} );
			List<TagResultVo> collect = list.stream().sorted(Comparator.comparing(TagResultVo::getCount).reversed()).limit(16).collect(Collectors.toList());
			return collect;
		} catch (Exception e) {
			log.error("热门标签处理异常",e.getMessage());
			throw new ActualException("热门标签信息处理异常"); 
		}
	}
	
	/***
	 * 更新文章阅读数
	 * @throws ActualException 自定义异常
	 */
	@Override
	public Boolean updateReadingQuantity(Integer readingQuantity,String id){
		try {
			Boolean updateReslult = showArticleMapper.updateReadingQuantity(readingQuantity, id);
			return updateReslult;
		} catch (Exception e) {
			log.error("阅读数更新失败 文章id：[{}],阅读量：[{}]",id,readingQuantity);
		}
		return false;
	}
	@Override
	public Integer selectArticleById(String id) {
		Integer selectArticleById = showArticleMapper.selectArticleById(id);
		return selectArticleById;
	}
	
	@Override
	public List<SearchResultVo> searchArticle(String articleTitle) throws ActualException {
		//查询文章标题与标签
		List<SearchResultVo> searchArticle = showArticleMapper.searchArticle();
		if(searchArticle.isEmpty() || searchArticle == null) {
			log.info("无内容");
			throw new ActualException("搜索无内容");
		}
	//	searchArticle.removeIf(re-> !re.getSearchResult().contains(articleTitle));
		
		
//		
//		searchArticle.forEach(System.out::println);
		Map<Boolean, List<SearchResultVo>> collect = searchArticle.stream().collect(Collectors.partitioningBy(re-> re.getSearchResult().contains(articleTitle)));
		List<SearchResultVo> searchResult= collect.get(true);
		
//		List<SearchResultVo> articleResult = new ArrayList<SearchResultVo>();
//		
//		for (int i = 0; i < searchArticle.size(); i++) {
//			//如果包含articleTitle 则返回此对象
//			if(searchArticle.get(i).getSearchResult().contains(articleTitle)) {
//				articleResult.add(searchArticle.get(i));
//			}
//		}
		return searchResult;
	}
}

