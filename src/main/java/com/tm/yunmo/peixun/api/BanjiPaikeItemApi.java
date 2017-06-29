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


    @RequestMapping("/queryBanjiPaikeItemListByInstitutionAndBanjiName")
    public List<BanjiPaikeItem> queryBanjiPaikeItemListByInstitutionAndBanjiName(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        String xiaoqu_name = request.getParameter("xiaoqu_name");
        String banji_name = request.getParameter("banji_name");
        List<BanjiPaikeItem> banjiPaikeItemList = banjiPaikeItemService.queryBanjiPaikeItemListByInstitutionAndBanjiName(institution_code,xiaoqu_name,banji_name);
        return banjiPaikeItemList;
    }



    @RequestMapping("/queryBanjiPaikeItemByInstitutionAndBanjiNameAndId")
    public BanjiPaikeItem queryBanjiPaikeItemByInstitutionAndBanjiNameAndId(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        String xiaoqu_name = request.getParameter("xiaoqu_name");
        String banji_name = request.getParameter("banji_name");
        int id = Integer.valueOf(request.getParameter("banji_name")).intValue();
        BanjiPaikeItem banjiPaikeItem = banjiPaikeItemService.queryBanjiPaikeItemByInstitutionAndBanjiNameAndId(institution_code,xiaoqu_name,banji_name,id);
        return banjiPaikeItem;
    }


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
