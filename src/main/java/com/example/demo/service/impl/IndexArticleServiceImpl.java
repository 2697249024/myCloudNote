package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Factory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ShowArticleMapper;
import com.example.demo.entity.Content;
import com.example.demo.entity.Tag;
import com.example.demo.entity.pojo.ArticleInsertPojo;
import com.example.demo.entity.pojo.ArticleTitle;
import com.example.demo.entity.pojo.ShowArticle;
import com.example.demo.service.IndexArticleService;
import com.example.demo.util.GetTimeUtil;
import com.example.demo.util.PageHelper;

@Service
@Transactional
public class IndexArticleServiceImpl implements IndexArticleService {
	
	private static final Logger log = LoggerFactory.getLogger(IndexArticleServiceImpl.class);
	
	@Autowired
	ShowArticleMapper showArticleMapper;
	
	@Override
	public List<ShowArticle> selectIndexArtilce(String id) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		Boolean insertArticle = showArticleMapper.insertArticle(articleInsertPojo);
		return insertArticle;
	}
	/**
	 * 文章分页查询
	 */
	@Override
	public List<ShowArticle> selecArtilceByPageHelper(Integer currentPage, Integer pageSize) {
		// TODO Auto-generated method stub
		try {
			List<ShowArticle> selecArtilceByPageHelper = showArticleMapper.selecArtilceByPageHelper(currentPage, pageSize);
			log.info("文章分页查询成功");
			return selecArtilceByPageHelper;
		} catch (Exception e) {
			// TODO: handle exception
			log.error(" 文章分页查询错误", e);
		}
		return null;
	}
	/**
	 * 统计笔记总数
	 * @return 总笔记数
	 */
	@Override
	public Integer selectCountArticle() {
		// TODO Auto-generated method stub
		Integer selectCountArticle = showArticleMapper.selectCountArticle();
		return selectCountArticle;
	}
	
	/***
	 * 更新标签内容
	 */
	@Override
	public Boolean insertTag(Tag tag) {
		// TODO Auto-generated method stub
		Boolean insertTag = showArticleMapper.insertTag(tag);
		return insertTag;
	}
	/**
	 * 更新详情内容
	 */
	@Override
	public Boolean insertContent(Content content) {
		// TODO Auto-generated method stub
		Boolean insertContent = showArticleMapper.insertContent(content);
		return insertContent;
	}
	/***
	 * 最终是否更新成功
	 */
	@Override
	public Boolean resultOfInseryArticle(String editorTitle, String editorIntro, String editorTag, String editorPicture,
			String editorDetails) {
		// TODO Auto-generated method stub
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
			System.out.println(nowTime);
			articleInsertPojo.setArticleCreateDate(nowTime);
			//标签id
			articleInsertPojo.setArticleTagId(uuid);
			//文章详情id
			articleInsertPojo.setArticleContentId(uuid);
			//标题 ,头, 图片
			articleInsertPojo.setArticleTitle(editorTitle);
			articleInsertPojo.setArticleIntro(editorIntro);
			articleInsertPojo.setArticlePicture(editorPicture);
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
	
}
