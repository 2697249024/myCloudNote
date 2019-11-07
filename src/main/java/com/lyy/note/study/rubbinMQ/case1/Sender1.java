package com.lyy.note.study.rubbinMQ.case1;

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
public class Sender1 {
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void send() {
        String sendMsg = "hello1 " + new Date();
        System.out.println("Sender1:" + sendMsg);
        rabbitTemplate.convertAndSend("helloQueue", sendMsg);
    }
	
}
