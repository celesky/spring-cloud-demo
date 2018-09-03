package com.example.helloservice.service;

import com.example.helloservice.amqp.RabbitmqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendMqService {

    @Autowired
    RabbitmqSender sender;

    public void send(String msg){
        sender.send(msg);
    }

}
