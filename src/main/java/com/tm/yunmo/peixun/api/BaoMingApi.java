package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.BaoMing;
import com.tm.yunmo.peixun.service.BaoMingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 * 学生rest接口
 */
@RestController
public class BaoMingApi {

    @Autowired
    private BaoMingService baoMingService;

//http://localhost:9999/queryBaoMingListBySFZCodeWithLike?institution_code=tm
    @RequestMapping("/queryBaoMingListByInstitution")
    public List<BaoMing> queryBaoMingListByInstitution(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        List<BaoMing> baoMingList = baoMingService.queryBaoMingListByInstitution(institution_code);
        return baoMingList;
    }


  //http://localhost:9999/queryBaoMingListBySFZCodeWithLike?institution_code=tm&sfzCode=362528
    @RequestMapping("/queryBaoMingListBySFZCodeWithLike")
    public List<BaoMing> queryBaoMingListBySFZCodeWithLike(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        String sfzCode = request.getParameter("sfzCode");
        List<BaoMing> baoMingList = baoMingService.queryBaoMingListBySFZCodeWithLike(institution_code, sfzCode);
        return baoMingList;
    }

//http://localhost:9999/queryBaoMingListByNameWithLike?institution_code=tm&name=%E6%98%8E
    @RequestMapping("/queryBaoMingListByNameWithLike")
    public List<BaoMing> queryBaoMingListByNameWithLike(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        String name = request.getParameter("name");
        List<BaoMing> baoMingList = baoMingService.queryBaoMingListByNameWithLike(institution_code, name);
        return baoMingList;
    }

    //http://localhost:9999/queryBaoMingListByXuehaoWithLike?institution_code=tm&xuehao=01
    @RequestMapping("/queryBaoMingListByXuehaoWithLike")
    public List<BaoMing> queryBaoMingListByXuehaoWithLike(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        String xuehao = request.getParameter("xuehao");
        List<BaoMing> baoMingList = baoMingService.queryBaoMingListByXuehaoWithLike(institution_code, xuehao);
        return baoMingList;
    }


    /**
     * POST http://localhost:9999/insertBaoMing HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 1331

     {
     "id": 3,
     "sfzCode": "362527",
     "name": "钭明3",
     "institution_code": "tm",
     "xuehao": "001",
     "kecheng_name": "拉丁舞3",
     "xiaoqu_name": "西可校区",
     "banji_name": "西可舞蹈1班",
     "chargeType": "keshi",
     "chargeFee": 100,
     "quantity": 3,
     "expireDate": 1506441600000,
     "originFee": 300,
     "youhui_type": "youhui",
     "youhui_quantity": 3000,
     "youhui_fee": 3000,
     "yingshou_zongji_fee": 270,
     "shoukuang_type": "xianjing",
     "duifang_zhanghu": "00000001",
     "liushui_danhao": "0000000001",
     "shishou_kuang": 270,
     "jiaocai_zafei_name1": "衣服",
     "jiaocai_zafei_name2": null,
     "jiaocai_zafei_name3": null,
     "jiaocai_zafei_name4": null,
     "jiaocai_zafei_name5": null,
     "jiaocai_zafei_price1": 200,
     "jiaocai_zafei_price2": 0,
     "jiaocai_zafei_price3": 0,
     "jiaocai_zafei_price4": 0,
     "jiaocai_zafei_price5": 0,
     "jiaocai_zafei_quantity1": 1,
     "jiaocai_zafei_quantity2": 0,
     "jiaocai_zafei_quantity3": 0,
     "jiaocai_zafei_quantity4": 0,
     "jiaocai_zafei_quantity5": 0,
     "jingban_xiaoqu_name": "西湖校区",
     "xiaoshou_source": "网络",
     "xiaoshou_yuan_name": "someone",
     "xiaoshou_yuan_sfz_code": "44444444",
     "createDate": null,
     "updateDate": null
     }
     * @param baoMing
     * @return
     */
    @RequestMapping("/insertBaoMing")
    public ResultModel insertBaoMing(@RequestBody BaoMing baoMing) {
        ResultModel resultModel = new ResultModel();

        int result = baoMingService.insertBaoMing(baoMing);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }

    }

    /**
     *
     * POST http://localhost:9999/updateBaoMing HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 1331

     {
     "id": 3,
     "sfzCode": "362527",
     "name": "钭明3",
     "institution_code": "tm",
     "xuehao": "001",
     "kecheng_name": "拉丁舞4",
     "xiaoqu_name": "西可校区",
     "banji_name": "西可舞蹈1班",
     "chargeType": "keshi",
     "chargeFee": 100,
     "quantity": 3,
     "expireDate": 1506441600000,
     "originFee": 300,
     "youhui_type": "youhui",
     "youhui_quantity": 3000,
     "youhui_fee": 3000,
     "yingshou_zongji_fee": 270,
     "shoukuang_type": "xianjing",
     "duifang_zhanghu": "00000001",
     "liushui_danhao": "0000000001",
     "shishou_kuang": 270,
     "jiaocai_zafei_name1": "衣服",
     "jiaocai_zafei_name2": null,
     "jiaocai_zafei_name3": null,
     "jiaocai_zafei_name4": null,
     "jiaocai_zafei_name5": null,
     "jiaocai_zafei_price1": 200,
     "jiaocai_zafei_price2": 0,
     "jiaocai_zafei_price3": 0,
     "jiaocai_zafei_price4": 0,
     "jiaocai_zafei_price5": 0,
     "jiaocai_zafei_quantity1": 1,
     "jiaocai_zafei_quantity2": 0,
     "jiaocai_zafei_quantity3": 0,
     "jiaocai_zafei_quantity4": 0,
     "jiaocai_zafei_quantity5": 0,
     "jingban_xiaoqu_name": "西湖校区",
     "xiaoshou_source": "网络",
     "xiaoshou_yuan_name": "someone",
     "xiaoshou_yuan_sfz_code": "44444444",
     "createDate": null,
     "updateDate": null
     }
     * @param baoMing
     * @return
     */
    @RequestMapping("/updateBaoMing")
    public ResultModel updateBaoMing(@RequestBody BaoMing baoMing) {
        ResultModel resultModel = new ResultModel();
        int result = baoMingService.updateBaoMing(baoMing);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    /**
     * POST http://localhost:9999/deleteBaoMing HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 1331

     {
     "id": 3,
     "sfzCode": "362527",
     "name": "钭明3",
     "institution_code": "tm",
     "xuehao": "001",
     "kecheng_name": "拉丁舞4",
     "xiaoqu_name": "西可校区",
     "banji_name": "西可舞蹈1班",
     "chargeType": "keshi",
     "chargeFee": 100,
     "quantity": 3,
     "expireDate": 1506441600000,
     "originFee": 300,
     "youhui_type": "youhui",
     "youhui_quantity": 3000,
     "youhui_fee": 3000,
     "yingshou_zongji_fee": 270,
     "shoukuang_type": "xianjing",
     "duifang_zhanghu": "00000001",
     "liushui_danhao": "0000000001",
     "shishou_kuang": 270,
     "jiaocai_zafei_name1": "衣服",
     "jiaocai_zafei_name2": null,
     "jiaocai_zafei_name3": null,
     "jiaocai_zafei_name4": null,
     "jiaocai_zafei_name5": null,
     "jiaocai_zafei_price1": 200,
     "jiaocai_zafei_price2": 0,
     "jiaocai_zafei_price3": 0,
     "jiaocai_zafei_price4": 0,
     "jiaocai_zafei_price5": 0,
     "jiaocai_zafei_quantity1": 1,
     "jiaocai_zafei_quantity2": 0,
     "jiaocai_zafei_quantity3": 0,
     "jiaocai_zafei_quantity4": 0,
     "jiaocai_zafei_quantity5": 0,
     "jingban_xiaoqu_name": "西湖校区",
     "xiaoshou_source": "网络",
     "xiaoshou_yuan_name": "someone",
     "xiaoshou_yuan_sfz_code": "44444444",
     "createDate": null,
     "updateDate": null
     }
     * @param baoMing
     * @return
     */
    @RequestMapping("/deleteBaoMing")
    public ResultModel deleteBaoMing(@RequestBody BaoMing baoMing) {
        ResultModel resultModel = new ResultModel();
        int result = baoMingService.deleteBaoMing(baoMing);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

}
