package com.song.mq.impl;

import com.song.mq.MQMessage;
import com.song.mq.MQProducer;

public class MQProducerImpl implements MQProducer {

    @Override
    public MQMessage createMessage(String topic) {
        MQMessage mqMsg = new MQMessage();
        mqMsg.setTopic(topic);
        return mqMsg;
    }

    @Override
    public void sendMessage(MQMessage mqMsg) {
        MQProxy.getInstance().sendMessage(mqMsg);
    }

}
