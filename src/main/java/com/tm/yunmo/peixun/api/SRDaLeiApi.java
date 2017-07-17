package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.SRDaLei;
import com.tm.yunmo.peixun.service.SRDaLeiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Huangqijun on 2017/7/16.
 */
@RestController
public class SRDaLeiApi {
    @Autowired
    private SRDaLeiService srDaLeiService;

    /**
     * http://localhost:9999/querySRDaLeiListByInstitution?institution_code=tm
     * @param request
     * @return
     */
    @RequestMapping("/querySRDaLeiListByInstitution")
    public List<SRDaLei> querySRDaLeiListByInstitution(HttpServletRequest request) {
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<SRDaLei> srDaLeiList = srDaLeiService.querySRDaLeiListByInstitution(institution_code);
        return srDaLeiList;
    }

    /**
     * http://localhost:9999/querySRDaLeiById?institution_code=tm&id=1
     * @param request
     * @return
     */
    @RequestMapping("/querySRDaLeiById")
    public SRDaLei querySRDaLeiById(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id")).intValue();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        SRDaLei srDaLei = srDaLeiService.querySRDaLeiById(id, institution_code);
        return srDaLei;
    }

    /**
     * http://localhost:9999/querySRDaLeiByName?institution_code=tm&name=%E8%A5%BF%E6%B9%96%E6%A0%A1%E5%8C%BA
     * @param request
     * @return
     */
    @RequestMapping("/querySRDaLeiByName")
    public SRDaLei querySRDaLeiByName(HttpServletRequest request) {
        String name = request.getParameter("name");
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        SRDaLei srDaLei = srDaLeiService.querySRDaLeiByName(name, institution_code);
        return srDaLei;
    }

    /**
     * http://localhost:9999/querySRDaLeiByNameWithLike?institution_code=tm&name=%E8%A5%BF%E6%B9%96%E6%A0%A1%E5%8C%BA
     * @param request
     * @return
     */
    @RequestMapping("/querySRDaLeiByNameWithLike")
    public ResultModel querySRDaLeiByNameWithLike(HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String name = request.getParameter("name");
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<SRDaLei> srDaLeiList = srDaLeiService.querySRDaLeiListByNameWithLike(name, institution_code);
        resultModel.setData(srDaLeiList);
        return resultModel;
    }


    /**
     * @param srDaLei
     * @param request
     * @return
     */
    @RequestMapping("/insertSRDaLei")
    public ResultModel insertSRDaLei(@RequestBody SRDaLei srDaLei, HttpServletRequest request) {

        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        srDaLei.setInstitution_code(institution_code);
        int result = srDaLeiService.insertSRDaLei(srDaLei);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }

    }


    /**
     * @param srDaLei
     * @param request
     * @return
     */
    @RequestMapping("/px/updateSRDaLei")
    public ResultModel updateSRDaLei(@RequestBody SRDaLei srDaLei,HttpServletRequest request) {
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        srDaLei.setInstitution_code(institution_code);
        ResultModel resultModel = new ResultModel();
        int result = srDaLeiService.updateSRDaLei(srDaLei);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    /**
     * @param srDaLei
     * @return
     */
    @RequestMapping("/deleteSRDaLei")
    public ResultModel deleteSRDaLei(@RequestBody SRDaLei srDaLei,HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        srDaLei.setInstitution_code(institution_code);
        int result = srDaLeiService.deleteSRDaLei(srDaLei);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }
}
