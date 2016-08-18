package com.song.mq;

import java.util.Date;

/**
 * 队列消息
 * 
 * @author songzigw
 *
 */
public class MQMessage {
    private String id;
    private String topic;
    private byte[] data;
    private Date createTime;

    public MQMessage() {
        createTime = new Date();
    }

    public String getId() {
        return this.id;
    }

    public String getTopic() {
        return this.topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
