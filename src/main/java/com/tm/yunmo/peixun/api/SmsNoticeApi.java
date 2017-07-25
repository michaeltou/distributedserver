package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.SmsNotice;
import com.tm.yunmo.peixun.service.SmsNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Huangqijun on 2017/7/25.
 * 短信通知
 */
@RestController
public class SmsNoticeApi {
    @Autowired
    private SmsNoticeService smsNoticeService;


    @RequestMapping("/querySmsNoticeListByInstitution")
    public List<SmsNotice> querySmsNoticeListByInstitution(HttpServletRequest request) {
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<SmsNotice> smsNoticeList = smsNoticeService.querySmsNoticeListByInstitution(institution_code);
        return smsNoticeList;
    }

    @RequestMapping("/querySmsNoticeById")
    public SmsNotice querySmsNoticeById(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id")).intValue();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        SmsNotice smsNotice = smsNoticeService.querySmsNoticeById(id, institution_code);
        return smsNotice;
    }

    @RequestMapping("/querySmsNoticeListBySendDate")
    public ResultModel querySmsNoticeListBySendDate(HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        Date startSendDate = StrToDate(request.getParameter("startSendDate"));
        if (startSendDate == null){
            startSendDate = StrToDate("2000-01-01 00:00:00");
        }
        Date endSendDate = StrToDate(request.getParameter("endSendDate"));
        if (endSendDate == null){
            endSendDate = StrToDate("2050-12-31 00:00:00");
        }
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<SmsNotice> smsNoticeList = smsNoticeService.querySmsNoticeListBySendDate(institution_code,startSendDate,endSendDate);
        resultModel.setData(smsNoticeList);
        return resultModel;
    }


    @RequestMapping("/insertSmsNotice")
    public ResultModel insertSmsNotice(@RequestBody SmsNotice smsNotice, HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        smsNotice.setInstitution_code(institution_code);
        int result = smsNoticeService.insertSmsNotice(smsNotice);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    @RequestMapping("/deleteSmsNotice")
    public ResultModel deleteSmsNotice(@RequestBody SmsNotice smsNotice, HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        smsNotice.setInstitution_code(institution_code);
        int result = smsNoticeService.deleteSmsNotice(smsNotice);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    /**
     * 字符串转换成日期
     * @param strDate
     * @return date
     */
    public static Date StrToDate(String strDate) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
