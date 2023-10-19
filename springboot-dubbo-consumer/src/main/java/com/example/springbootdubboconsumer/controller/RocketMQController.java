package com.example.springbootdubboconsumer.controller;

import com.example.springbootdubboconsumer.mq.MQProducerService;
import jakarta.annotation.Resource;
import org.apache.rocketmq.client.producer.SendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rocketmq")
public class RocketMQController {
    @Resource
    private MQProducerService mqProducerService;

    @GetMapping("/send")
    public void send(){
        mqProducerService.send("Yuxiulei");
    }

    @GetMapping("/sendTagMsg")
    public SendResult sendTagMsg(){
        SendResult sendResult = mqProducerService.sendTagMsg("yuxiulei, 带有tag");
        return sendResult;
    }
}
