package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.SRXiaoLei;
import com.tm.yunmo.peixun.service.SRXiaoLeiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Huangqijun on 2017/7/17.
 */
@RestController
public class SRXiaoLeiApi {

    @Autowired
    private SRXiaoLeiService srXiaoLeiService;

    /**
     * http://localhost:9999/querySRXiaoLeiListByInstitution?institution_code=tm
     * @param request
     * @return
     */
    @RequestMapping("/querySRXiaoLeiListByInstitution")
    public List<SRXiaoLei> querySRXiaoLeiListByInstitution(HttpServletRequest request) {
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<SRXiaoLei> srXiaoLeiList = srXiaoLeiService.querySRXiaoLeiListByInstitution(institution_code);
        return srXiaoLeiList;
    }

    /**
     * http://localhost:9999/querySRXiaoLeiById?institution_code=tm&id=1
     * @param request
     * @return
     */
    @RequestMapping("/querySRXiaoLeiById")
    public SRXiaoLei querySRXiaoLeiById(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id")).intValue();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        SRXiaoLei srXiaoLei = srXiaoLeiService.querySRXiaoLeiById(id, institution_code);
        return srXiaoLei;
    }

    /**
     * http://localhost:9999/querySRXiaoLeiByName?institution_code=tm&name=%E8%A5%BF%E6%B9%96%E6%A0%A1%E5%8C%BA
     * @param request
     * @return
     */
    @RequestMapping("/querySRXiaoLeiByName")
    public SRXiaoLei querySRXiaoLeiByName(HttpServletRequest request) {
        String name = request.getParameter("name");
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        SRXiaoLei srXiaoLei = srXiaoLeiService.querySRXiaoLeiByName(name, institution_code);
        return srXiaoLei;
    }

    /**
     * http://localhost:9999/querySRXiaoLeiByNameWithLike?institution_code=tm&name=%E8%A5%BF%E6%B9%96%E6%A0%A1%E5%8C%BA
     * @param request
     * @return
     */
    @RequestMapping("/querySRXiaoLeiByNameWithLike")
    public ResultModel querySRXiaoLeiByNameWithLike(HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String name = request.getParameter("name");
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<SRXiaoLei> srXiaoLeiList = srXiaoLeiService.querySRXiaoLeiListByNameWithLike(name, institution_code);
        resultModel.setData(srXiaoLeiList);
        return resultModel;
    }


    /**
     * @param srXiaoLei
     * @param request
     * @return
     */
    @RequestMapping("/insertSRXiaoLei")
    public ResultModel insertSRXiaoLei(@RequestBody SRXiaoLei srXiaoLei, HttpServletRequest request) {

        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        srXiaoLei.setInstitution_code(institution_code);
        int result = srXiaoLeiService.insertSRXiaoLei(srXiaoLei);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }

    }


    /**
     * @param srXiaoLei
     * @param request
     * @return
     */
    @RequestMapping("/px/updateSRXiaoLei")
    public ResultModel updateSRDaLei(@RequestBody SRXiaoLei srXiaoLei,HttpServletRequest request) {
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        srXiaoLei.setInstitution_code(institution_code);
        ResultModel resultModel = new ResultModel();
        int result = srXiaoLeiService.updateSRXiaoLei(srXiaoLei);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    /**
     * @param srXiaoLei
     * @return
     */
    @RequestMapping("/deleteSRXiaoLei")
    public ResultModel deleteSRDaLei(@RequestBody SRXiaoLei srXiaoLei,HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        srXiaoLei.setInstitution_code(institution_code);
        int result = srXiaoLeiService.deleteSRXiaoLei(srXiaoLei);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

}
