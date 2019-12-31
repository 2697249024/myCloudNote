package com.lyy.note.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lyy.note.exception.ActualException;
import com.lyy.note.service.IndexArticleService;

@Aspect
@Component
public class ArticleAspect {
	
	private static final Logger logger =LoggerFactory.getLogger(ArticleAspect.class);
	@Autowired
	IndexArticleService indexArticleService;
	
	 private final String POINT_CUT = "execution(* com.lyy.note.controller.ArticleController.showAticle(..))";
	/**
	 * 添加切面：查询首页文章信息  @Around 环绕通知   切点-> ProceedingJoinPoint  proceedingJoinPoint.proceed(); //返回原方法 --> 继续执行环绕
	 * @throws ActualException 
	 * @Before不支持ProceedingJoinPoint 支持:JoinPoint
	 * 
	 */
	@Before(value = POINT_CUT) //前置通知
	public void showAticleAspect(JoinPoint joinPoint) throws ActualException {
		try {
			logger.info("进入切面showAticleAspect,方法："+joinPoint.getSignature().getName());
			//获取参数
			 Object[] args = joinPoint.getArgs();
			 if(args.length==0 || args == null || args[0]==null) {
				 logger.info("当前传参id为空，不做更新阅读数处理");
				 return;
			 }
			 String parmsId =(String)args[0];
			 logger.info("当前文章id为："+parmsId);
			//根据id 查询文章阅读数
			 Integer readingQuantity = indexArticleService.selectArticleById(parmsId);
			 //增加阅读数
			 readingQuantity ++;
			//更新阅读量
			indexArticleService.updateReadingQuantity(readingQuantity, parmsId);
		} catch (Exception e) {
			logger.error("文章阅读数增加异常,不做更新阅读数处理",e);
		}
	}
}
