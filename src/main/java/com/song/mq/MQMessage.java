package com.song.mq;

import java.util.Date;
import java.util.EventObject;

/**
 * 队列消息
 * 
 * @author songzigw
 *
 */
public class MQMessage extends EventObject {

    private static final long serialVersionUID = 2962282464078178557L;

    private String id;
    private String topic;
    private byte[] data;
    private Date createTime;

    public MQMessage() {
        super(null);
        createTime = new Date();
    }

    @Override
    public String getSource() {
        return topic;
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
