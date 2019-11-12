package com.lyy.note.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestArticleController {

	private MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception{
	mockMvc = MockMvcBuilders.standaloneSetup(new articleController()).build();
	}
	//TODO test
	@Test
	public void testShowAticle() {
		try {
			mockMvc.perform(MockMvcRequestBuilders.post("/showAticle").accept(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
