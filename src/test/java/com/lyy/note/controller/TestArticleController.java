//package com.lyy.note.controller;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.lyy.note.service.IndexArticleService;
//import com.lyy.note.service.impl.IndexArticleServiceImpl;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TestArticleController {
//
//	@Autowired
//	IndexArticleService indexArticleService;
//	
//	@Autowired
//	IndexArticleServiceImpl indexArticleServiceImpl;
//	
//
//	@Autowired
//	articleController articleController;
//	
//	private MockMvc mockMvc;
//	
//	@Before
//	public void setUp() throws Exception{
//	mockMvc = MockMvcBuilders.standaloneSetup(new articleController()).build();
//	}
//	@Test
//	public void testShowAticle() {
//		try {
//			String result = mockMvc.perform(MockMvcRequestBuilders.post("/showAticle")
//					.param("id", "1")   //添加参数
//					.accept(MediaType.APPLICATION_JSON))
//					.andReturn().getResponse().getContentAsString(); //获取方法的返回值
//			
//			System.out.println("result:"+result);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//}
