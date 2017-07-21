package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.SchoolNotice;
import com.tm.yunmo.peixun.service.SchoolNoticeService;
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
 * Created by Huangqijun on 2017/7/20.
 * 校内通知rest接口
 */
@RestController
public class SchoolNoticeApi {
    @Autowired
    private SchoolNoticeService schoolNoticeService;


    @RequestMapping("/querySchoolNoticeListByInstitution")
    public List<SchoolNotice> querySchoolNoticeListByInstitution(HttpServletRequest request) {
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<SchoolNotice> schoolNoticeList = schoolNoticeService.querySchoolNoticeListByInstitution(institution_code);
        return schoolNoticeList;
    }

    @RequestMapping("/querySchoolNoticeById")
    public SchoolNotice querySchoolNoticeById(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id")).intValue();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        SchoolNotice schoolNotice = schoolNoticeService.querySchoolNoticeById(id, institution_code);
        return schoolNotice;
    }

    @RequestMapping("/querySchoolNoticeListByPublishDate")
    public ResultModel querySchoolNoticeListByPublishDate(HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        Date startPublishDate = StrToDate(request.getParameter("startPublishDate"));
        if (startPublishDate == null){
            startPublishDate = StrToDate("2000-01-01 00:00:00");
        }
        Date endPublishDate = StrToDate(request.getParameter("endPublishDate"));
        if (endPublishDate == null){
            endPublishDate = StrToDate("2050-12-31 00:00:00");
        }
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<SchoolNotice> schoolNoticeList = schoolNoticeService.querySchoolNoticeListByPublishDate(institution_code,startPublishDate,endPublishDate);
        resultModel.setData(schoolNoticeList);
        return resultModel;
    }


    @RequestMapping("/insertSchoolNotice")
    public ResultModel insertSchoolNotice(@RequestBody SchoolNotice schoolNotice, HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        schoolNotice.setInstitution_code(institution_code);
        int result = schoolNoticeService.insertSchoolNotice(schoolNotice);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    @RequestMapping("/deleteSchoolNotice")
    public ResultModel deleteSchoolNotice(@RequestBody SchoolNotice schoolNotice, HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        schoolNotice.setInstitution_code(institution_code);
        int result = schoolNoticeService.deleteSchoolNotice(schoolNotice);
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
