package com.lyy.note.study.kafka.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Component;

/**
 * kafka消费者测试
 * @author 80004198
 *
 */

@Component
public class TestConsumer {

	
	public void listen(ConsumerRecord<?, ?> record) throws Exception {
	  //控制台打印send进来的信息
      System.out.printf("topic = %s, offset = %d, value = %s \n", record.topic(), record.offset(), record.value());
	}
}

