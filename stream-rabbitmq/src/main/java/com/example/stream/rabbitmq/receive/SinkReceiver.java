package com.example.stream.rabbitmq.receive;

import com.example.stream.rabbitmq.send.SinkSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

/**
 * sink接口:该接口是 Spring Cloud Stream中默认实现的对输入消息通道绑定的定义
 * 接口通过@Input注解绑定了一个名为input的通道
 *
 *
 *
 */
@EnableBinding(value = {Sink.class, SinkSender.class})
public class SinkReceiver {
    private static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

    /**
     * 注解StreamListener 作用是将被修饰的方法注册为消息中间件上数据流的事件监听器，
     * 注解中的属性值对应了监听的消息通道名
     * @param payload
     */
    @StreamListener(Sink.INPUT)
    public void receive(Object payload){
        logger.info("received payload:"+payload);
    }
}
