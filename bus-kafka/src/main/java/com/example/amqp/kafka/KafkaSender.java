package com.example.amqp.kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @desc:
 * @author: panqiong
 * @date: 2018/9/2
 */
@Component
@Slf4j
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    public void send(Long i){
        Message message = new Message();
        message.setId(i);
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        log.info("========发送消息  "+i+" >>>>{}<<<<<==========",gson.toJson(message));
        kafkaTemplate.send("wqh",gson.toJson(message));
    }




}
