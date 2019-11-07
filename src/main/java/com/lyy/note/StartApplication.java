package com.lyy.note;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartApplication {
	protected static final Logger logger = LoggerFactory.getLogger(StartApplication.class);
	// 启动类声明一个Queue,用于测试
	/*
	 * @Bean public Queue helloQueue() { return new Queue("helloQueue"); }
	 */

	public static void main(String[] args) {
		logger.info("SpringBoot开始加载");
		SpringApplication.run(StartApplication.class, args);
		logger.info("SpringBoot加载结束");
	}

	
}
