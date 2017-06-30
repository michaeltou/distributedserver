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

//http://localhost:9999/queryBanjiPaikeRuleListByInstitutionAndBanjiName?institution_code=tm&xiaoqu_name=%E8%A5%BF%E5%8F%AF%E6%A0%A1%E5%8C%BA&banji_name=%E8%A5%BF%E5%8F%AF1%E7%8F%AD
    @RequestMapping("/queryBanjiPaikeRuleListByInstitutionAndBanjiName")
    public List<BanjiPaikeRule> queryBanjiPaikeRuleListByInstitutionAndBanjiName(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        String xiaoqu_name = request.getParameter("xiaoqu_name");
        String banji_name = request.getParameter("banji_name");
        List<BanjiPaikeRule> banjiPaikeRuleList = banjiPaikeRuleService.queryBanjiPaikeRuleListByInstitutionAndBanjiName(institution_code,xiaoqu_name,banji_name);
        return banjiPaikeRuleList;
    }


    /**
     * POST http://localhost:9999/insertBanjiPaikeRule HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 431

     {
     "id": 1,
     "institution_code": "tm",
     "xiaoqu_name": "西可校区",
     "banji_name": "西可2班",
     "classroom_name": "西可2教室",
     "dateBegin": 1483200000000,
     "dateEnd": 1485878400000,
     "startDay": 6,
     "endDay": 7,
     "timeStartHour": 10,
     "timeStartMinute": 0,
     "timeEndHour": 12,
     "timeEndMinute": 0,
     "status": "1",
     "createDate": null,
     "updateDate": null
     }
     * @param banjiPaikeRule
     * @return
     */
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


    /**
     * POST http://localhost:9999/updateBanjiPaikeRule HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 431

     {
     "id": 2,
     "institution_code": "tm",
     "xiaoqu_name": "西可校区",
     "banji_name": "西可2班",
     "classroom_name": "西可2教室",
     "dateBegin": 1483200000000,
     "dateEnd": 1485878400000,
     "startDay": 3,
     "endDay": 4,
     "timeStartHour": 10,
     "timeStartMinute": 0,
     "timeEndHour": 12,
     "timeEndMinute": 0,
     "status": "1",
     "createDate": null,
     "updateDate": null
     }
     * @param banjiPaikeRule
     * @return
     */
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


    /**
     * POST http://localhost:9999/deleteBanjiPaikeRule HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 431

     {
     "id": 2,
     "institution_code": "tm",
     "xiaoqu_name": "西可校区",
     "banji_name": "西可2班",
     "classroom_name": "西可2教室",
     "dateBegin": 1483200000000,
     "dateEnd": 1485878400000,
     "startDay": 3,
     "endDay": 4,
     "timeStartHour": 10,
     "timeStartMinute": 0,
     "timeEndHour": 12,
     "timeEndMinute": 0,
     "status": "1",
     "createDate": null,
     "updateDate": null
     }
     * @param banjiPaikeRule
     * @return
     */
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
