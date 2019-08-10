package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCloudConfigClientApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads() {
        String routingKey = "dashen";
        // 通过广播模式发布延时消息 延时30分钟 持久化消息 消费后销毁 这里无需指定路由，会广播至每个绑定此交换机的队列
//        rabbitTemplate.convertAndSend("Delay_Exchange_Name", "", "hello dashe ", message ->{
//            message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
//            message.getMessageProperties().setDelay(30 * (60*1000));   // 毫秒为单位，指定此消息的延时时长
//            return message;
//        });
        Message message = new Message("hello".getBytes(),new MessageProperties());


        rabbitTemplate.convertAndSend(routingKey,message);
    }

}
