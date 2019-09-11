package com.example.demo.study.rubbinMQ.case1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * 测试类
 * @author 80004198
 *
 */
@RestController
public class RabbitController {
	 @Autowired
	 private Sender1 helloSender1;
	 @Autowired
	 private Sender2 helloSender2;
	
	 @RequestMapping("/hello")
	 public String hello() {
        helloSender1.send();
        helloSender2.send();
        return "ok";
	 }
}
