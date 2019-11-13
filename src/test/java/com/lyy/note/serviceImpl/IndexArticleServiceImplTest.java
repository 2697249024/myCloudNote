package com.lyy.note.serviceImpl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lyy.note.exception.ActualException;
import com.lyy.note.service.IndexArticleService;
import com.lyy.note.service.impl.IndexArticleServiceImpl;

/***
 * 单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IndexArticleServiceImplTest {

	
	@Mock
	IndexArticleService indexArticleService;
	
	@InjectMocks
	@Autowired
	IndexArticleServiceImpl indexArticleServiceImpl;
	
	
	/**
	 * 更新文章标题
	 */
	@Test
	public void TestUpdateReadingQuantity() {
		Integer readingQuantity =3;
		String id ="1";
		Boolean updateReadingQuantity = false;
		try {
			updateReadingQuantity = indexArticleServiceImpl.updateReadingQuantity(readingQuantity, id);
			Assert.assertEquals(updateReadingQuantity, true);
		} catch (Exception e) {
			if(e instanceof ActualException) {
				System.out.println("ActualException:"+e.getMessage());
				Assert.assertEquals(updateReadingQuantity, false);
			}
		}
	}
	
}
