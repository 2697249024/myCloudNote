package com.example.demo.study.rubbinMQ.case1;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/***
 * 1.单生产者和单消费者
 * @author 80004198
 */
//生产者1
@Component
public class Sender2 {
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void send() {
        String sendMsg = "hello2 " + new Date();
        System.out.println("Sender2:" + sendMsg);
        rabbitTemplate.convertAndSend("helloQueue", sendMsg);
    }
	
}
