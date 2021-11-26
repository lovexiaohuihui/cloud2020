package com.bochao.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
/**
 * 消息消费
 * @author 吴军杰
 * */
@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT) // 监听消息
    public void input(Message<String> message) {
        log.info("第一个消费者 接收到的消息 " + message.getPayload() + " 端口号:" + serverPort);
    }
}
