package com.example.stream.rabbitmq.send;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

public interface SinkSender {

    @Output(Sink.INPUT)
    MessageChannel output();
}
