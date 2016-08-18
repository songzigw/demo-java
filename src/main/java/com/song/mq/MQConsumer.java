package com.song.mq;

/**
 * 消息的消费者
 * 
 * @author songzigw
 *
 */
public interface MQConsumer {

    void addListener(String topic, String consumeGroup, MQListener listener);
}
