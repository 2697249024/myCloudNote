package com.example.demo.study.rubbinMQ.case1;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * helloQueue消费者2
 */
@Component
//@RabbitListener(queues = "helloQueue")
public class HelloReceiver2 {
	//@RabbitHandler
    public void process(String mesg) {
        System.out.println("Receiver2:" + mesg);
    }
}
