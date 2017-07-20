package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.ZCXiaoLei;
import com.tm.yunmo.peixun.service.ZCXiaoLeiService;
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
public class ZCXiaoLeiApi {

    @Autowired
    private ZCXiaoLeiService zcXiaoLeiService;

    /**
     * http://localhost:9999/queryZCXiaoLeiListByInstitution?institution_code=tm
     * @param request
     * @return
     */
    @RequestMapping("/queryZCXiaoLeiListByInstitution")
    public List<ZCXiaoLei> queryZCXiaoLeiListByInstitution(HttpServletRequest request) {
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<ZCXiaoLei> zcXiaoLeiList = zcXiaoLeiService.queryZCXiaoLeiListByInstitution(institution_code);
        return zcXiaoLeiList;
    }

    @RequestMapping("/queryZCXiaoLeiListByDaLeiName")
    public ResultModel queryZCXiaoLeiListByDaLeiName(HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        String daLeiName = request.getParameter("daLeiName");
        List<ZCXiaoLei> zcXiaoLeiList = zcXiaoLeiService.queryZCXiaoLeiListByDaLeiName(daLeiName,institution_code);
        resultModel.setData(zcXiaoLeiList);
        return resultModel;
    }

    /**
     * http://localhost:9999/queryZCXiaoLeiById?institution_code=tm&id=1
     * @param request
     * @return
     */
    @RequestMapping("/queryZCXiaoLeiById")
    public ZCXiaoLei queryZCXiaoLeiById(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id")).intValue();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        ZCXiaoLei zcXiaoLei = zcXiaoLeiService.queryZCXiaoLeiById(id, institution_code);
        return zcXiaoLei;
    }

    /**
     * http://localhost:9999/queryZCXiaoLeiByName?institution_code=tm&name=%E8%A5%BF%E6%B9%96%E6%A0%A1%E5%8C%BA
     * @param request
     * @return
     */
    @RequestMapping("/queryZCXiaoLeiByName")
    public ZCXiaoLei queryZCXiaoLeiByName(HttpServletRequest request) {
        String name = request.getParameter("name");
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        ZCXiaoLei zcXiaoLei = zcXiaoLeiService.queryZCXiaoLeiByName(name, institution_code);
        return zcXiaoLei;
    }

    /**
     * http://localhost:9999/queryZCXiaoLeiByNameWithLike?institution_code=tm&name=%E8%A5%BF%E6%B9%96%E6%A0%A1%E5%8C%BA
     * @param request
     * @return
     */
    @RequestMapping("/queryZCXiaoLeiByNameWithLike")
    public ResultModel queryZCXiaoLeiByNameWithLike(HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String name = request.getParameter("name");
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<ZCXiaoLei> zcXiaoLeiList = zcXiaoLeiService.queryZCXiaoLeiListByNameWithLike(name, institution_code);
        resultModel.setData(zcXiaoLeiList);
        return resultModel;
    }


    /**
     * @param zcXiaoLei
     * @param request
     * @return
     */
    @RequestMapping("/insertZCXiaoLei")
    public ResultModel insertZCXiaoLei(@RequestBody ZCXiaoLei zcXiaoLei, HttpServletRequest request) {

        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        zcXiaoLei.setInstitution_code(institution_code);
        int result = zcXiaoLeiService.insertZCXiaoLei(zcXiaoLei);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }

    }


    /**
     * @param zcXiaoLei
     * @param request
     * @return
     */
    @RequestMapping("/px/updateZCXiaoLei")
    public ResultModel updateZCXiaoLei(@RequestBody ZCXiaoLei zcXiaoLei,HttpServletRequest request) {
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        zcXiaoLei.setInstitution_code(institution_code);
        ResultModel resultModel = new ResultModel();
        int result = zcXiaoLeiService.updateZCXiaoLei(zcXiaoLei);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    /**
     * @param zcXiaoLei
     * @return
     */
    @RequestMapping("/deleteZCXiaoLei")
    public ResultModel deleteZCXiaoLei(@RequestBody ZCXiaoLei zcXiaoLei,HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        zcXiaoLei.setInstitution_code(institution_code);
        int result = zcXiaoLeiService.deleteZCXiaoLei(zcXiaoLei);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }
}
