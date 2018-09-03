package com.example.helloservice.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "payCallBackQueue")
public class RabbitmqReceiver {

    @RabbitHandler
    public void process(String msg){
        System.out.println("received payCallBackQueue msg:  " + msg);
    }
}
