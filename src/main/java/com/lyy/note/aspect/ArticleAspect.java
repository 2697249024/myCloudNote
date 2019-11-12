//package com.lyy.note.aspect;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.lyy.note.service.IndexArticleService;
//
//@Aspect
//@Component
//public class ArticleAspect {
//	
//	private static final Logger logger =LoggerFactory.getLogger(ArticleAspect.class);
//	@Autowired
//	IndexArticleService indexArticleService;
//	
//	/**
//	 * 添加切面：查询首页文章信息
//	 */
//	@Around("execution(* com.lyy.note.controller.articleController.showAticle(..))")
//	public void showAticleAspect(ProceedingJoinPoint proceedingJoinPoint) {
//		logger.info("进入切面showAticleAspect,方法："+proceedingJoinPoint.getSignature().getName());
//		//获取参数
//		 Object[] args = proceedingJoinPoint.getArgs();
//		 if(args.length==0) {
//			 logger.info("当前传参id为空，不做更新阅读数处理");
//			 return;
//		 }
//		 String parmsId =(String)args[0];
//		 logger.info("当前文章id为："+parmsId);
//		//根据id 查询文章阅读数
//		 Integer readingQuantity = indexArticleService.selectArticleById(parmsId);
//		 //增加阅读数
//		 readingQuantity ++;
//		//更新阅读量
//		indexArticleService.updateReadingQuantity(readingQuantity, parmsId);
//	}
//	
//	
//
//}
