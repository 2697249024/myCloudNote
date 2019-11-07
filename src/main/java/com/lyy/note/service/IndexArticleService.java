package com.lyy.note.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lyy.note.entity.ArticlePageHelperParam;
import com.lyy.note.entity.Content;
import com.lyy.note.entity.Tag;
import com.lyy.note.entity.pojo.ArticleInsertPojo;
import com.lyy.note.entity.pojo.ArticleTitle;
import com.lyy.note.entity.pojo.ShowArticle;
import com.lyy.note.entity.vo.TagResultVo;
import com.lyy.note.exception.ActualException;
import com.lyy.note.util.PageHelper;

/***
 * 展示页文章内容
 * @author 80004198
 *
 */
public interface IndexArticleService {
	/***
	 * 查询首页文章信息
	 */
	List<ShowArticle> selectIndexArtilce(String id);
	
	/**
	 * 文章分页查询
	 */
	List<ShowArticle> selecArtilceByPageHelper(ArticlePageHelperParam articlePageHelperParam);
	/**
	 * 统计笔记总数
	 * @return 总笔记数
	 */
	Integer selectCountArticle(String tags);
	/***
	 *  根据日期排序查询前12条文章标题
	 */
	List<ArticleTitle> selectArticleTitle();
	/**
	 * 插入文章内容
	 */
	Boolean insertArticle(ArticleInsertPojo articleInsertPojo);
	
	/**
	 *最终插入是否成功
	 */
	
	Boolean resultOfInseryArticle(String editorTitle,String editorIntro,String editorTag, String editorPicture,String editorDetails);
	/**
	 * 插入标签内容
	 */
	Boolean insertTag(Tag tag);
	/**
	 * 插入详情内容 
	 */
	Boolean insertContent(Content content);
	
	
	/***
	 * 获取热门标签
	 * @return 标签集合
	 * @throws ActualException 
	 */
	List<TagResultVo> selectHotLabels() throws ActualException;
	
}
