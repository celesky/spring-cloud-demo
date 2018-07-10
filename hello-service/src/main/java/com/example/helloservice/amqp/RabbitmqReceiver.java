package com.example.helloservice.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class RabbitmqReceiver {

    @RabbitHandler
    public void process(String msg){
        System.out.println("received msg:  " + msg);
    }
}
