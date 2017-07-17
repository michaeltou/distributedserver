package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.ZCDaLei;
import com.tm.yunmo.peixun.service.ZCDaLeiService;
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
public class ZCDaLeiApi {

    @Autowired
    private ZCDaLeiService zcDaLeiService;

    /**
     * http://localhost:9999/queryZCDaLeiListByInstitution?institution_code=tm
     * @param request
     * @return
     */
    @RequestMapping("/queryZCDaLeiListByInstitution")
    public ResultModel queryZCDaLeiListByInstitution(HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<ZCDaLei> zcDaLeiList = zcDaLeiService.queryZCDaLeiListByInstitution(institution_code);
        resultModel.setData(zcDaLeiList);
        return resultModel;
    }

    /**
     * http://localhost:9999/queryZCDaLeiById?institution_code=tm&id=1
     * @param request
     * @return
     */
    @RequestMapping("/queryZCDaLeiById")
    public ZCDaLei queryZCDaLeiById(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id")).intValue();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        ZCDaLei zcDaLei = zcDaLeiService.queryZCDaLeiById(id, institution_code);
        return zcDaLei;
    }

    /**
     * http://localhost:9999/queryZCDaLeiByName?institution_code=tm&name=%E8%A5%BF%E6%B9%96%E6%A0%A1%E5%8C%BA
     * @param request
     * @return
     */
    @RequestMapping("/queryZCDaLeiByName")
    public ZCDaLei queryZCDaLeiByName(HttpServletRequest request) {
        String name = request.getParameter("name");
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        ZCDaLei zcDaLei = zcDaLeiService.queryZCDaLeiByName(name, institution_code);
        return zcDaLei;
    }

    /**
     * http://localhost:9999/queryZCDaLeiByNameWithLike?institution_code=tm&name=%E8%A5%BF%E6%B9%96%E6%A0%A1%E5%8C%BA
     * @param request
     * @return
     */
    @RequestMapping("/queryZCDaLeiByNameWithLike")
    public ResultModel queryZCDaLeiByNameWithLike(HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String name = request.getParameter("name");
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<ZCDaLei> zcDaLeiList = zcDaLeiService.queryZCDaLeiListByNameWithLike(name, institution_code);
        resultModel.setData(zcDaLeiList);
        return resultModel;
    }


    /**
     * @param zcDaLei
     * @param request
     * @return
     */
    @RequestMapping("/insertZCDaLei")
    public ResultModel insertZCDaLei(@RequestBody ZCDaLei zcDaLei, HttpServletRequest request) {

        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        zcDaLei.setInstitution_code(institution_code);
        int result = zcDaLeiService.insertZCDaLei(zcDaLei);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }

    }


    /**
     * @param zcDaLei
     * @param request
     * @return
     */
    @RequestMapping("/px/updateZCDaLei")
    public ResultModel updateZCDaLei(@RequestBody ZCDaLei zcDaLei,HttpServletRequest request) {
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        zcDaLei.setInstitution_code(institution_code);
        ResultModel resultModel = new ResultModel();
        int result = zcDaLeiService.updateZCDaLei(zcDaLei);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    /**
     * @param zcDaLei
     * @return
     */
    @RequestMapping("/deleteZCDaLei")
    public ResultModel deleteZCDaLei(@RequestBody ZCDaLei zcDaLei,HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        zcDaLei.setInstitution_code(institution_code);
        int result = zcDaLeiService.deleteZCDaLei(zcDaLei);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }
}
