package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.SmsNoticeDAO;
import com.tm.yunmo.peixun.model.SmsNotice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by Huangqijun on 2017/7/25.
 */
@Component
public class SmsNoticeService {
    @Autowired
    private SmsNoticeDAO smsNoticeDAO;

    public List<SmsNotice> querySmsNoticeListByInstitution(String institution_code){
        List<SmsNotice> smsNoticeList = smsNoticeDAO.querySmsNoticeListByInstitution( institution_code);
        return smsNoticeList;
    }

    public SmsNotice querySmsNoticeById( int id,  String institution_code) {
        SmsNotice smsNotice = smsNoticeDAO.querySmsNoticeById(id, institution_code);
        return smsNotice;
    }

    public List<SmsNotice> querySmsNoticeListBySendDate(String institution_code , Date startSendDate, Date endSendDate){
        List<SmsNotice> smsNoticeList = smsNoticeDAO.querySmsNoticeListBySendDate( institution_code,startSendDate,endSendDate);
        return smsNoticeList;
    }


    public int insertSmsNotice(SmsNotice smsNotice) {
        int result = smsNoticeDAO.insertSmsNotice(smsNotice);
        return result;
    }

    public int deleteSmsNotice(SmsNotice smsNotice) {
        int result = smsNoticeDAO.deleteSmsNotice(smsNotice);
        return result;
    }
}
