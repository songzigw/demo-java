package com.song.mq;

/**
 * 消息监听器
 * 
 * @author songzigw
 *
 */
public interface MQListener {

    void onMessage(MQMessage mqMsg);
}
