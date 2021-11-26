package com.bochao.service.impl;

import com.bochao.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 消息提供者接口实现类
 * @author 吴军杰
 * */
@EnableBinding(Source.class) // 定义消息的推送管道
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public void send() {
        String uuid = UUID.randomUUID().toString();
        log.info(uuid);
        output.send(MessageBuilder.withPayload(uuid).build());
    }
}
