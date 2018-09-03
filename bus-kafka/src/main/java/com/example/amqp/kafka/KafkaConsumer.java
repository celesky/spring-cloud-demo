package com.example.amqp.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;


/**
 * @desc:
 * @author: panqiong
 * @date: 2018/9/2
 */
@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = {"wanqh","wqh"})
    public void consumer(ConsumerRecord<?,?> consumerRecord){
        //判断是否为null
        Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
        log.info(">>>>>>>>>> record =" + kafkaMessage);
        if(kafkaMessage.isPresent()){
            //得到Optional实例中的值
            Object message = kafkaMessage.get();
            log.info(">>>>>>>>接收消息message =" + message);
        }
    }
}
