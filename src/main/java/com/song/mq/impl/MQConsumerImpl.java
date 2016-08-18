package com.song.mq.impl;

import com.song.mq.MQConsumer;
import com.song.mq.MQListener;

public class MQConsumerImpl implements MQConsumer {

    @Override
    public void addListener(String topic, String consumeGroup,
            MQListener listener) {
        MQProxy.getInstance().addListener(topic, consumeGroup, listener);
    }

}
