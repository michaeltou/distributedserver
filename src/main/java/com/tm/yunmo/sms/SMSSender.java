package com.tm.yunmo.sms;

import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.CloudTopic;
import com.aliyun.mns.client.MNSClient;
import com.aliyun.mns.common.ServiceException;
import com.aliyun.mns.model.BatchSmsAttributes;
import com.aliyun.mns.model.MessageAttributes;
import com.aliyun.mns.model.RawTopicMessage;
import com.aliyun.mns.model.TopicMessage;

import java.util.*;

/**
 * Created by daoying on 2017/5/9.
 * 短信发送功能类
 *
 */
public class SMSSender {


    public static void main(String[] args) {
        testSingleSendSms();
    }

    public static void testBatchSendSms(){
        String templateCode = "SMS_66480046";
        Map<String ,String> keyValues = new HashMap<String ,String>();
        keyValues.put("customer","钭明");
        List<String> phoneNoList = new ArrayList<>();
        phoneNoList.add("18658160158");
        String signName = "云模网络";
        batchSendSMS(templateCode,keyValues,phoneNoList,signName);
    }

    public static void testSingleSendSms(){
        String templateCode = "SMS_66480046";
        Map<String ,String> keyValues = new HashMap<String ,String>();
        keyValues.put("customer","钭明");
        String phoneNo = "18658160158";
        String signName = "云模网络";
        sendSMS(templateCode,keyValues,phoneNo,signName);
    }


    /**
     * 发送短信
     * 这里提供的是单个发送短信的功能，即：给一个电话号使用知道的短信模板进行发送.
     * @param templateCode
     * @param keyValues
     * @param phoneNo
     * @return
     */
    public static boolean sendSMS(String templateCode,Map keyValues, String phoneNo,String signName){

        if (templateCode == null || templateCode.isEmpty()){
            return false;
        }

        if (phoneNo == null || phoneNo.isEmpty()){
            return false;
        }
        List<String> phoneNoList = new ArrayList<>();
        phoneNoList.add(phoneNo);

        batchSendSMS(templateCode,keyValues,phoneNoList,signName);
        return true;

    }

    /**
     * 批量发送短信
     * 这里的批量是指多个电话号码，同一个短信模板，相同的短信参数.
     * @param templateCode
     * @param keyValues
     * @param phoneNoList
     * @return
     */
    public static boolean batchSendSMS(String templateCode,Map keyValues, List<String> phoneNoList,String signName){

        if (phoneNoList.isEmpty()){
            return false;
        }
        if (templateCode == null || templateCode.isEmpty()){
            return false;
        }

        /**
         * Step 1. 获取主题引用
         */
        CloudAccount account = new CloudAccount("LTAIa8iksr13c9tr", "K3UpMDkw4EvP6z8mHzJdvSn2IN71hi", "https://1979194233674081.mns.cn-shanghai.aliyuncs.com/");
        MNSClient client = account.getMNSClient();
        CloudTopic topic = client.getTopicRef("sms.topic-cn-shanghai");
        /**
         * Step 2. 设置SMS消息体（必须）
         *
         * 注：目前暂时不支持消息内容为空，需要指定消息内容，不为空即可。
         */
        RawTopicMessage msg = new RawTopicMessage();
        msg.setMessageBody("sms-message");
        /**
         * Step 3. 生成SMS消息属性
         */
        MessageAttributes messageAttributes = new MessageAttributes();
        BatchSmsAttributes batchSmsAttributes = new BatchSmsAttributes();
        // 3.1 设置发送短信的签名（SMSSignName）
        batchSmsAttributes.setFreeSignName(signName);
        // 3.2 设置发送短信使用的模板（SMSTempateCode）
        batchSmsAttributes.setTemplateCode(templateCode);
        // 3.3 设置发送短信所使用的模板中参数对应的值（在短信模板中定义的，没有可以不用设置）
        BatchSmsAttributes.SmsReceiverParams smsReceiverParams = new BatchSmsAttributes.SmsReceiverParams();

        Set<String> keys = keyValues.keySet();
        if (!keys.isEmpty()) {
            for (String key :
                    keys) {
                String value = (String) keyValues.get(key);
                smsReceiverParams.setParam(key, value);
            }
        }

        if (!phoneNoList.isEmpty()){
            for (String phoneNo:phoneNoList   ) {
             // 3.4 增加接收短信的号码
                batchSmsAttributes.addSmsReceiver(phoneNo, smsReceiverParams);
            }
        }


        messageAttributes.setBatchSmsAttributes(batchSmsAttributes);
        try {
            /**
             * Step 4. 发布SMS消息
             */
            TopicMessage ret = topic.publishMessage(msg, messageAttributes);
            System.out.println("MessageId: " + ret.getMessageId());
            System.out.println("MessageMD5: " + ret.getMessageBodyMD5());
        } catch (ServiceException se) {
            System.out.println(se.getErrorCode() + se.getRequestId());
            System.out.println(se.getMessage());
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        client.close();
        return true;
    }
}
