package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.ShouZhiDetail;
import com.tm.yunmo.peixun.service.ShouZhiDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Huangqijun on 2017/7/19.
 * 收支明细rest接口
 */
@RestController
public class ShouZhiDetailApi {
    @Autowired
    private ShouZhiDetailService shouZhiDetailService;


    @RequestMapping("/queryShouZhiDetailListByInstitution")
    public List<ShouZhiDetail> queryShouZhiDetailListByInstitution(HttpServletRequest request) {
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<ShouZhiDetail> shouZhiDetailList = shouZhiDetailService.queryShouZhiDetailListByInstitution(institution_code);
        return shouZhiDetailList;
    }

    @RequestMapping("/queryShouZhiDetailById")
    public ShouZhiDetail queryShouZhiDetailById(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id")).intValue();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        ShouZhiDetail shouZhiDetail = shouZhiDetailService.queryShouZhiDetailById(id, institution_code);
        return shouZhiDetail;
    }



    @RequestMapping("/queryShouZhiDetailListByType")
    public ResultModel queryShouZhiDetailListByType(HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        Byte type = Byte.valueOf(request.getParameter("type")).byteValue();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<ShouZhiDetail> shouZhiDetailList = null;
        if(type == 0){
            // 全部查询
                shouZhiDetailList = queryShouZhiDetailListByInstitution(request);
        }else {
            // 1:收入,2:支出
            shouZhiDetailList = shouZhiDetailService.queryShouZhiDetailListByType(type, institution_code);
        }
        resultModel.setData(shouZhiDetailList);
        return resultModel;
    }

    @RequestMapping("/insertShouZhiDetail")
    public ResultModel insertShouZhiDetail(@RequestBody ShouZhiDetail shouZhiDetail, HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        shouZhiDetail.setInstitution_code(institution_code);
        int result = shouZhiDetailService.insertShouZhiDetail(shouZhiDetail);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    @RequestMapping("/updateShouZhiDetail")
    public ResultModel updateShouZhiDetail(@RequestBody ShouZhiDetail shouZhiDetail, HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        shouZhiDetail.setInstitution_code(institution_code);
        int result = shouZhiDetailService.updateShouZhiDetail(shouZhiDetail);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    @RequestMapping("/updateShouZhiDetailStatus")
    public ResultModel updateShouZhiDetailStatus(@RequestBody ShouZhiDetail shouZhiDetail, HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        shouZhiDetail.setInstitution_code(institution_code);
        int result = shouZhiDetailService.updateShouZhiDetailStatus(shouZhiDetail);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }



    @RequestMapping("/deleteShouZhiDetail")
    public ResultModel deleteShouZhiDetail(@RequestBody ShouZhiDetail shouZhiDetail, HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        shouZhiDetail.setInstitution_code(institution_code);
        int result = shouZhiDetailService.deleteShouZhiDetail(shouZhiDetail);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }
}
