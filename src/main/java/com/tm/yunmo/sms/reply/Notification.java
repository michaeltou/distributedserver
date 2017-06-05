package com.tm.yunmo.sms.reply;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by daoying on 2017/5/11.
 */
@XmlRootElement(name = "Notification")
public class Notification {

    private String TopicOwner;
    private String TopicName;
    private String Subscriber;
    private String SubscriptionName;
    private String MessageId;
    private String Message;
    private String MessageMD5;
    private String MessageTag;
    private String MessagePublishTime;

    @XmlElement(name="TopicOwner")
    public void setTopicOwner(String topicOwner) {
        TopicOwner = topicOwner;
    }

    @XmlElement(name="TopicName")
    public void setTopicName(String topicName) {
        TopicName = topicName;
    }
    @XmlElement(name="Subscriber")
    public void setSubscriber(String subscriber) {
        Subscriber = subscriber;
    }
    @XmlElement(name="SubscriptionName")
    public void setSubscriptionName(String subscriptionName) {
        SubscriptionName = subscriptionName;
    }
    @XmlElement(name="MessageId")
    public void setMessageId(String messageId) {
        MessageId = messageId;
    }
    @XmlElement(name="Message")
    public void setMessage(String message) {
        Message = message;
    }
    @XmlElement(name="MessageMD5")
    public void setMessageMD5(String messageMD5) {
        MessageMD5 = messageMD5;
    }
    @XmlElement(name="MessageTag")
    public void setMessageTag(String messageTag) {
        MessageTag = messageTag;
    }
    @XmlElement(name="MessagePublishTime")
    public void setMessagePublishTime(String messagePublishTime) {
        MessagePublishTime = messagePublishTime;
    }

    public String getTopicOwner() {
        return TopicOwner;
    }

    public String getTopicName() {
        return TopicName;
    }

    public String getSubscriber() {
        return Subscriber;
    }

    public String getSubscriptionName() {
        return SubscriptionName;
    }

    public String getMessageId() {
        return MessageId;
    }

    public String getMessage() {
        return Message;
    }

    public String getMessageMD5() {
        return MessageMD5;
    }

    public String getMessageTag() {
        return MessageTag;
    }

    public String getMessagePublishTime() {
        return MessagePublishTime;
    }
}
