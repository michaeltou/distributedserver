package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.QingJiaDan;
import com.tm.yunmo.peixun.service.QingJiaDanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Huangqijun on 2017/7/29.
 */
@RestController
public class QingJiaDanApi {
    @Autowired
    private QingJiaDanService qingJiaDanService;

    @RequestMapping("/queryQingJiaDanListByInstitution")
    public List<QingJiaDan> queryQingJiaDanListByInstitution(HttpServletRequest request) {
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<QingJiaDan> qingJiaDanList = qingJiaDanService.queryQingJiaDanListByInstitution(institution_code);
        return qingJiaDanList;
    }

    @RequestMapping("/queryQingJiaDanById")
    public QingJiaDan queryQingJiaDanById(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id")).intValue();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        QingJiaDan qingJiaDan = qingJiaDanService.queryQingJiaDanById(id, institution_code);
        return qingJiaDan;
    }


    @RequestMapping("/insertQingJiaDan")
    public ResultModel insertQingJiaDan(@RequestBody QingJiaDan qingJiaDan, HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        qingJiaDan.setInstitution_code(institution_code);
        int result = qingJiaDanService.insertQingJiaDan(qingJiaDan);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    @RequestMapping("/updateQingJiaDanStatus")
    public ResultModel updateQingJiaDanStatus(@RequestBody QingJiaDan qingJiaDan, HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        qingJiaDan.setInstitution_code(institution_code);
        int result = qingJiaDanService.updateQingJiaDanStatus(qingJiaDan);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    @RequestMapping("/deleteQingJiaDan")
    public ResultModel deleteQingJiaDan(@RequestBody QingJiaDan qingJiaDan, HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        qingJiaDan.setInstitution_code(institution_code);
        int result = qingJiaDanService.deleteQingJiaDan(qingJiaDan);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }
}
