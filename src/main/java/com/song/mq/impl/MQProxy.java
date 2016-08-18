package com.song.mq.impl;

import java.util.HashMap;
import java.util.Map;

import com.song.mq.MQListener;
import com.song.mq.MQMessage;

/**
 * 消息代理
 * 
 * @author songzigw
 *
 */
public class MQProxy {

    private static MQProxy instance;

    private Map<String, MQListener> listeners;

    private MQProxy() {
        listeners = new HashMap<String, MQListener>();
    }

    public static MQProxy getInstance() {
        if (instance == null) {
            instance = new MQProxy();
        }
        return instance;
    }

    public void sendMessage(MQMessage mqMsg) {
        MQListener listener = listeners.get(mqMsg.getTopic());
        if (listener != null) {
            listener.onMessage(mqMsg);
        }
    }

    public void addListener(String subjectPrefix, String consumeGroup,
            MQListener listener) {
        listeners.put(subjectPrefix + consumeGroup, listener);
    }
}
