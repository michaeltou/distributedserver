package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.BanjiPaikeItem;
import com.tm.yunmo.peixun.service.BanjiPaikeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 * 班级排课日程表rest接口
 */
@RestController
public class BanjiPaikeItemApi {

    @Autowired
    private BanjiPaikeItemService banjiPaikeItemService;


    //http://localhost:9999/queryBanjiPaikeRuleListByInstitutionAndBanjiName?institution_code=tm&xiaoqu_name=%E8%A5%BF%E5%8F%AF%E6%A0%A1%E5%8C%BA&banji_name=%E8%A5%BF%E5%8F%AF1%E7%8F%AD
    @RequestMapping("/queryBanjiPaikeItemListByInstitutionAndBanjiName")
    public List<BanjiPaikeItem> queryBanjiPaikeItemListByInstitutionAndBanjiName(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        String xiaoqu_name = request.getParameter("xiaoqu_name");
        String banji_name = request.getParameter("banji_name");
        List<BanjiPaikeItem> banjiPaikeItemList = banjiPaikeItemService.queryBanjiPaikeItemListByInstitutionAndBanjiName(institution_code,xiaoqu_name,banji_name);
        return banjiPaikeItemList;
    }



    //http://localhost:9999/queryBanjiPaikeItemByInstitutionAndBanjiNameAndId?institution_code=tm&xiaoqu_name=%E8%A5%BF%E5%8F%AF%E6%A0%A1%E5%8C%BA&banji_name=%E8%A5%BF%E5%8F%AF1%E7%8F%AD&id=1
    @RequestMapping("/queryBanjiPaikeItemByInstitutionAndBanjiNameAndId")
    public BanjiPaikeItem queryBanjiPaikeItemByInstitutionAndBanjiNameAndId(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        String xiaoqu_name = request.getParameter("xiaoqu_name");
        String banji_name = request.getParameter("banji_name");
        int id = Integer.valueOf(request.getParameter("id")).intValue();
        BanjiPaikeItem banjiPaikeItem = banjiPaikeItemService.queryBanjiPaikeItemByInstitutionAndBanjiNameAndId(institution_code,xiaoqu_name,banji_name,id);
        return banjiPaikeItem;
    }


    /**
     * POST http://localhost:9999/insertBanjiPaikeItem HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 453

     {
     "id": 1,
     "institution_code": "tm",
     "xiaoqu_name": "西可校区",
     "classroom_name": "西可1教室",
     "start_date": 1483200000000,
     "end_date": 1483200000000,
     "banji_name": "西可1班",
     "teacher_name": "张三",
     "jiaoshi_sfzCode": "3625",
     "assist_teacher_name": "李四",
     "assist_teacher_sfzCode": "42000",
     "status": "1",
     "rule_id": 1,
     "createDate": null,
     "updateDate": null
     }
     * @param banjiPaikeItem
     * @return
     */
    @RequestMapping("/insertBanjiPaikeItem")
    public ResultModel insertBanjiPaikeItem(@RequestBody BanjiPaikeItem banjiPaikeItem) {
        ResultModel resultModel = new ResultModel();

        int result = banjiPaikeItemService.insertBanjiPaikeItem(banjiPaikeItem);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }

    }


    /**
     * POST http://localhost:9999/updateBanjiPaikeItem HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 453

     {
     "id": 2,
     "institution_code": "tm",
     "xiaoqu_name": "西可校区",
     "classroom_name": "西可1教室",
     "start_date": 1483600000000,
     "end_date": 1483800000000,
     "banji_name": "西可1班",
     "teacher_name": "张三",
     "jiaoshi_sfzCode": "3625",
     "assist_teacher_name": "李四",
     "assist_teacher_sfzCode": "42000",
     "status": "1",
     "rule_id": 2,
     "createDate": null,
     "updateDate": null
     }
     * @param banjiPaikeItem
     * @return
     */
    @RequestMapping("/updateBanjiPaikeItem")
    public ResultModel updateBanjiPaikeItem(@RequestBody BanjiPaikeItem banjiPaikeItem) {
        ResultModel resultModel = new ResultModel();
        int result = banjiPaikeItemService.updateBanjiPaikeItem(banjiPaikeItem);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }


    /**
     *POST http://localhost:9999/deleteBanjiPaikeItem HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 453

     {
     "id": 2,
     "institution_code": "tm",
     "xiaoqu_name": "西可校区",
     "classroom_name": "西可1教室",
     "start_date": 1483600000000,
     "end_date": 1483800000000,
     "banji_name": "西可1班",
     "teacher_name": "张三",
     "jiaoshi_sfzCode": "3625",
     "assist_teacher_name": "李四",
     "assist_teacher_sfzCode": "42000",
     "status": "1",
     "rule_id": 2,
     "createDate": null,
     "updateDate": null
     }
     * @param banjiPaikeItem
     * @return
     */
    @RequestMapping("/deleteBanjiPaikeItem")
    public ResultModel deleteBanjiPaikeItem(@RequestBody BanjiPaikeItem banjiPaikeItem) {
        ResultModel resultModel = new ResultModel();
        int result = banjiPaikeItemService.deleteBanjiPaikeItem(banjiPaikeItem);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

}
