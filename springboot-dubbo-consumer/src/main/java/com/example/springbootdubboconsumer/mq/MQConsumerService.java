package com.example.springbootdubboconsumer.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Component
public class MQConsumerService {
    @Service
    @RocketMQMessageListener(topic = "RLT_TEST_TOPIC", selectorExpression = "tag1", consumerGroup = "Con_Group_One")
    public class ConsumerSend implements RocketMQListener<String>{

        /*
        * 监听到消息就会执行此方法
        * */
        @Override
        public void onMessage(String s) {
            log.info("监听到消息: name = {}", s);
        }
    }

    @Service
    @RocketMQMessageListener(topic = "RLT_TEST_TOPIC", selectorExpression = "tag2", consumerGroup = "Con_Group_Two")
    public class ConsumerSend2 implements RocketMQListener<String>{

        @Override
        public void onMessage(String s) {
            log.info("监听到消息: s = {}", s);
        }
    }


}
