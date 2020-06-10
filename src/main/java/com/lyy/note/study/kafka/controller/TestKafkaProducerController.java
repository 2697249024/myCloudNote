package com.lyy.note.study.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/***
   *  测试kafka生产者
 * @author 80004198
 *
 */
@RestController
@RequestMapping(value = "kafka")
public class TestKafkaProducerController {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	
	public String send(String msg) {
		kafkaTemplate.send("test_topic", msg);
		return "success add";
	}
	
}
