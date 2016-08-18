package com.song.mq;

import java.util.EventListener;

/**
 * 消息监听器
 * 
 * @author songzigw
 *
 */
public interface MQListener extends EventListener {

    void onMessage(MQMessage mqMsg);
}
