package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.JiaoCaiZaFei;
import com.tm.yunmo.peixun.model.SchoolAccount;
import com.tm.yunmo.peixun.service.JiaoCaiZaFeiService;
import com.tm.yunmo.peixun.service.SchoolAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lenovo on 2017/7/18.
 */
@RestController
public class SchoolAccountApi {

    @Autowired
    private SchoolAccountService schoolAccountService;


    @RequestMapping("/querySchoolAccountListByInstitution")
    public List<SchoolAccount> querySchoolAccountListByInstitution(HttpServletRequest request) {
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<SchoolAccount> schoolAccountList = schoolAccountService.querySchoolAccountListByInstitution(institution_code);
        return schoolAccountList;
    }

    @RequestMapping("/querySchooAccountlListModelByInstitution")
    public ResultModel querySchooAccountlListModelByInstitution(HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<SchoolAccount> schoolAccountList = schoolAccountService.querySchoolAccountListByInstitution(institution_code);
        resultModel.setData(schoolAccountList);
        return resultModel;
    }

    @RequestMapping("/querySchoolAccountById")
    public SchoolAccount querySchoolAccountById(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id")).intValue();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        SchoolAccount schoolAccount = schoolAccountService.querySchoolAccountById(id, institution_code);
        return schoolAccount;
    }


    @RequestMapping("/querySchoolAccountByName")
    public SchoolAccount querySchoolAccountByName(HttpServletRequest request) {
        String name =  request.getParameter("name");
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        SchoolAccount schoolAccount = schoolAccountService.querySchoolAccountByName(name, institution_code);
        return schoolAccount;
    }

    @RequestMapping("/querySchoolAccountByNameWithLike")
    public ResultModel querySchoolAccountByNameWithLike(HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String name = request.getParameter("name");
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<SchoolAccount> schoolAccountList = schoolAccountService.querySchoolAccountListByNameWithLike(name, institution_code);
        resultModel.setData(schoolAccountList);
        return resultModel;
    }

    @RequestMapping("/insertSchoolAccount")
    public ResultModel insertSchoolAccount(@RequestBody SchoolAccount schoolAccount, HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        schoolAccount.setInstitution_code(institution_code);
        int result = schoolAccountService.insertSchoolAccount(schoolAccount);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    @RequestMapping("/updateSchoolAccount")
    public ResultModel updateSchoolAccount(@RequestBody SchoolAccount schoolAccount, HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        schoolAccount.setInstitution_code(institution_code);
        int result = schoolAccountService.updateSchoolAccount(schoolAccount);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    @RequestMapping("/deleteSchoolAccount")
    public ResultModel deleteSchoolAccount(@RequestBody SchoolAccount schoolAccount, HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        schoolAccount.setInstitution_code(institution_code);
        int result = schoolAccountService.deleteSchoolAccount(schoolAccount);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }
}
