package com.example.springbootdubboconsumer.mq;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class MQProducerService {
    @Value("${rocketmq.producer.send-message-timeout}")
    private Integer messageTimeout;

    /*
    * 建议正常规模项目统一用一个topic
    * */
    private static final String topic = "RLT_TEST_TOPIC";

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    /*
    * 普通发送(可以发送对象，也可以是字符串)
    * */
    public void send(String name){
        rocketMQTemplate.convertAndSend(topic + ":tag1" + name);
//        rocketMQTemplate.send(topic + ":tag1", MessageBuilder.withPayload(name).build());
    }

    /*
    * 发送同步消息（阻塞当前线程, 等待broker响应发送结果, 这样不太容易丢失消息）
    * （sendResult为返回的发送结果）
    * */
    public org.apache.rocketmq.client.producer.SendResult sendMsg(String name){
        SendResult sendResult = rocketMQTemplate.syncSend(topic, MessageBuilder.withPayload(name).build());
        log.info("【sendMsg】 sendResult = {}", name);
        return sendResult;
    }

    /*
    * 发送带tag的消息,直接在topic后面加上":tag"
    * */
    public SendResult sendTagMsg(String name){
        return rocketMQTemplate.syncSend(topic + ":tag2", MessageBuilder.withPayload(name).build());
    }
}
