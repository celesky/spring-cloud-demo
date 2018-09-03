package com.example.helloservice.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class RabbitmqSender {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    public void send(String msg){
        msg = "hello !"+ LocalDateTime.now().format(DateTimeFormatter.ISO_DATE)+" |"+msg;
        System.out.println("send msg = " + msg);
        this.rabbitmqTemplate.convertAndSend("payCallBackQueue",msg);
    }
}
