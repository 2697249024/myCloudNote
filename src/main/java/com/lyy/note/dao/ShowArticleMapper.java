package com.lyy.note.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lyy.note.entity.ArticlePageHelperParam;
import com.lyy.note.entity.Content;
import com.lyy.note.entity.Tag;
import com.lyy.note.entity.pojo.ArticleInsertPojo;
import com.lyy.note.entity.pojo.ArticleTitle;
import com.lyy.note.entity.pojo.ShowArticle;

@Mapper
public interface ShowArticleMapper {
	
	/***
	 * 查询首页文章信息
	 */
	List<ShowArticle> selectIndexArtilce(@Param("id") String id);
	/**
	 * 文章分页查询
	 */
	List<ShowArticle> selecArtilceByPageHelper(ArticlePageHelperParam articlePageHelperParam);
	/**
	 * 统计笔记总数
	 * @return 总笔记数
	 */
	Integer selectCountArticle(@Param("tags") String tags);
	/***
	 *  根据日期排序查询前12条文章标题
	 * @return
	 */
	List<ArticleTitle> selectArticleTitle();
	/**
	 * 插入文章内容
	 */
	Boolean insertArticle(ArticleInsertPojo articleInsertPojo);
	/**
	 * 插入标签内容
	 */
	Boolean insertTag(Tag tag);
	/**
	 * 插入详情内容 
	 */
	Boolean insertContent(Content content);
	
	/***
	 *获取所有标签信息
	 */
	List<Tag> selectAllLabels();
	
}
