package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.KeChengChargeInfo;
import com.tm.yunmo.peixun.service.KeChengChargeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by daoying on 2017/6/20.
 * 课程收费信息rest接口
 */
@RestController
public class KeChengChargeInfoApi {

    @Autowired
    private KeChengChargeInfoService keChengChargeInfoService;


    /**
     * http://localhost:9999/queryKeChengChargeInfoByKechengName?kecheng_name=%E8%88%9E%E8%B9%88&institution_code=tm
     *
     * @param request
     * @return
     */
    @RequestMapping("/queryKeChengChargeInfoByKechengName")
    public  KeChengChargeInfo queryKeChengChargeInfoByKechengName(HttpServletRequest request){
        String kecheng_name =  request.getParameter("kecheng_name");
        String institution_code =  request.getParameter("institution_code");
        KeChengChargeInfo keChengChargeInfo = keChengChargeInfoService.queryKeChengChargeInfoByKechengName(kecheng_name,institution_code);
        return keChengChargeInfo;
    }


    /**
     * POST http://localhost/sendSMS?accessToken=10937866-0c89-46ea-a19a-11c19ee0928d HTTP/1.1
     Host: localhost
     Content-Type: application/json;charset=UTF-8
     Content-Length: 204

     {
     "templateCode":"SMS_66480047",
     "phoneNoList":"18658160158,18958137606,13588312290,18717947096",
     "signName":"云模网络",
     "keys":"code,product",
     "values":"2234,云模人工智能"
     }
     * @param keChengChargeInfo
     * @return
     */

    @RequestMapping("/insertKeChengChargeInfo")
    public ResultModel insertKeChengChargeInfo(@RequestBody  KeChengChargeInfo keChengChargeInfo){
        ResultModel resultModel = new ResultModel();
       int result =   keChengChargeInfoService.insertKeChengChargeInfo(keChengChargeInfo);
       if (result>0 ){
           return resultModel;
       }else{
           resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
           return resultModel;
       }

    }


    @RequestMapping("/updateKeChengChargeInfo")
    public ResultModel updateKeChengChargeInfo(@RequestBody KeChengChargeInfo keChengChargeInfo){
        ResultModel resultModel = new ResultModel();
        int result =   keChengChargeInfoService.updateKeChengChargeInfo(keChengChargeInfo);
        if (result>0 ){
            return resultModel;
        }else{
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }


    @RequestMapping("/deleteKeChengChargeInfoByKeChengName")
    public ResultModel  deleteKeChengChargeInfoByKeChengName( @RequestBody KeChengChargeInfo keChengChargeInfo){
        ResultModel resultModel = new ResultModel();
        int result =   keChengChargeInfoService.deleteKeChengChargeInfoByKeChengName(keChengChargeInfo);
        if (result>0 ){
            return resultModel;
        }else{
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

}
