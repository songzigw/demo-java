package com.song.mq;

/**
 * 消息的生产者
 * 
 * @author songzigw
 *
 */
public interface MQProducer {

    MQMessage createMessage(String topic);

    void sendMessage(MQMessage mqMsg);
}
