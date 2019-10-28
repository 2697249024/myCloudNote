package com.lyy.note.study.rubbinMQ.case1;
/***
 * 消费者1
 * @author 80004198
 *
 */

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
//@RabbitListener(queues = "helloQueue") //@RabbitListener 注解标记方法，当监听到队列 helloQueue 中有消息时则会进行接收并处理
public class HelloReceiver1 {
	//@RabbitHandler //@RabbitListener 标注在类上面表示当有收到消息的时候，就交给 @RabbitHandler 的方法处理，具体使用哪个方法处理，根据 MessageConverter 转换后的参数类型
	public void process(String hello) {
        System.out.println("Receiver1:" + hello);
    }
}
