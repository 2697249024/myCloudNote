package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Content;
import com.example.demo.entity.Tag;
import com.example.demo.entity.pojo.ArticleInsertPojo;
import com.example.demo.entity.pojo.ArticleTitle;
import com.example.demo.entity.pojo.ShowArticle;
import com.example.demo.util.PageHelper;

@Mapper
public interface ShowArticleMapper {
	
	/***
	 * 查询首页文章信息
	 */
	List<ShowArticle> selectIndexArtilce(@Param("id") String id);
	/**
	 * 文章分页查询
	 */
	List<ShowArticle> selecArtilceByPageHelper(@Param("currentPage") Integer currentPage,@Param("pageSize") Integer pageSize);
	/**
	 * 统计笔记总数
	 * @return 总笔记数
	 */
	Integer selectCountArticle();
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
	
}
