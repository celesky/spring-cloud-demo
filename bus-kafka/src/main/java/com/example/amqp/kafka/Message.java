package com.example.amqp.kafka;

import lombok.Data;

import java.util.Date;

/**
 * @desc:
 * @author: panqiong
 * @date: 2018/9/2
 */
@Data
public class Message {
    private Long id;//id
    private String msg; //消息
    private Date sendTime; //发送时间
}