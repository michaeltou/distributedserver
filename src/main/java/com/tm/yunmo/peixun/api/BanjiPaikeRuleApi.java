package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.BanjiPaikeRule;
import com.tm.yunmo.peixun.service.BanjiPaikeRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 * 班级排课规则表rest接口
 */
@RestController
public class BanjiPaikeRuleApi {

    @Autowired
    private BanjiPaikeRuleService banjiPaikeRuleService;


    @RequestMapping("/queryBanjiPaikeRuleListByInstitution")
    public List<BanjiPaikeRule> queryBanjiPaikeRuleListByInstitutionAndBanjiName(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        String xiaoqu_name = request.getParameter("xiaoqu_name");
        String banji_name = request.getParameter("banji_name");
        List<BanjiPaikeRule> banjiPaikeRuleList = banjiPaikeRuleService.queryBanjiPaikeRuleListByInstitutionAndBanjiName(institution_code,xiaoqu_name,banji_name);
        return banjiPaikeRuleList;
    }




    @RequestMapping("/insertBanjiPaikeRule")
    public ResultModel insertBanjiPaikeRule(@RequestBody BanjiPaikeRule banjiPaikeRule) {
        ResultModel resultModel = new ResultModel();

        int result = banjiPaikeRuleService.insertBanjiPaikeRule(banjiPaikeRule);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }

    }



    @RequestMapping("/updateBanjiPaikeRule")
    public ResultModel updateBanjiPaikeRule(@RequestBody BanjiPaikeRule banjiPaikeRule) {
        ResultModel resultModel = new ResultModel();
        int result = banjiPaikeRuleService.updateBanjiPaikeRule(banjiPaikeRule);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }



    @RequestMapping("/deleteBanjiPaikeRule")
    public ResultModel deleteBanjiPaikeRule(@RequestBody BanjiPaikeRule banjiPaikeRule) {
        ResultModel resultModel = new ResultModel();
        int result = banjiPaikeRuleService.deleteBanjiPaikeRule(banjiPaikeRule);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

}
