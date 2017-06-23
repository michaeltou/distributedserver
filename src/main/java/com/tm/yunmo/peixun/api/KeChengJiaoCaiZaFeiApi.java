package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.KeChengJiaoCaiZaFei;
import com.tm.yunmo.peixun.service.KeChengJiaoCaiZaFeiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 * 课程教材杂费rest接口
 */
@RestController
public class KeChengJiaoCaiZaFeiApi {

    @Autowired
    private KeChengJiaoCaiZaFeiService keChengJiaoCaiZaFeiService;


    /**
     *  http://localhost:9999/queryKeChengJiaoCaiZaFeiListByKechengName?kecheng_name=%E8%8A%AD%E8%95%BE%E8%88%9E&institution_code=tm
     */
    @RequestMapping("/queryKeChengJiaoCaiZaFeiListByKechengName")
    public List<KeChengJiaoCaiZaFei> queryKeChengJiaoCaiZaFeiListByKechengName(HttpServletRequest request){
        String kecheng_name =  request.getParameter("kecheng_name");
        String institution_code =  request.getParameter("institution_code");
        List<KeChengJiaoCaiZaFei> keChengJiaoCaiZaFeiList = keChengJiaoCaiZaFeiService.queryKeChengJiaoCaiZaFeiListByKechengName( kecheng_name,institution_code);
        return keChengJiaoCaiZaFeiList;
    }


    /**
     POST http://localhost:9999/insertKeChengJiaoCaiZaFei HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 161

     {
     "name":"跳舞衣服",
     "quantity":"3"
     ,
     "price":"300"
     ,
     "totalFee":"900",
     "status":"1",
     "institution_code":"tm" ,
     "kecheng_name":"拉丁舞"
     }

     * @param keChengJiaoCaiZaFei
     * @return
     */
    @RequestMapping("/insertKeChengJiaoCaiZaFei")
    public ResultModel insertKeChengJiaoCaiZaFei(@RequestBody KeChengJiaoCaiZaFei keChengJiaoCaiZaFei) {
        ResultModel resultModel = new ResultModel();

        int result =   keChengJiaoCaiZaFeiService.insertKeChengJiaoCaiZaFei(keChengJiaoCaiZaFei);
        if (result>0 ){
            return resultModel;
        }else{
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    /**
     * POST http://localhost:9999/updateKeChengJiaoCaiZaFei HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 167



     {
     "name":"跳舞衣服",
     "quantity":"4",
     "price":"300"
     ,
     "totalFee":"1200",
     "status":"1",
     "institution_code":"tm" ,
     "kecheng_name":"拉丁舞"
     }


     * @param keChengJiaoCaiZaFei
     * @return
     */
    @RequestMapping("/updateKeChengJiaoCaiZaFei")
    public ResultModel updateKeChengJiaoCaiZaFei(@RequestBody KeChengJiaoCaiZaFei keChengJiaoCaiZaFei) {
        ResultModel resultModel = new ResultModel();

        int result =   keChengJiaoCaiZaFeiService.updateKeChengJiaoCaiZaFei(keChengJiaoCaiZaFei);
        if (result>0 ){
            return resultModel;
        }else{
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }


    /**
     * POST http://localhost:9999/deleteKeChengJiaoCaiZaFei HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 162

     {
     "name":"跳舞衣服2",
     "quantity":"3"
     ,
     "price":"300"
     ,
     "totalFee":"900",
     "status":"1",
     "institution_code":"tm" ,
     "kecheng_name":"拉丁舞"
     }


     * @param keChengJiaoCaiZaFei
     * @return
     */
    @RequestMapping("/deleteKeChengJiaoCaiZaFei")
    public ResultModel deleteKeChengJiaoCaiZaFei(@RequestBody KeChengJiaoCaiZaFei keChengJiaoCaiZaFei) {
        ResultModel resultModel = new ResultModel();

        int result =   keChengJiaoCaiZaFeiService.deleteKeChengJiaoCaiZaFei(keChengJiaoCaiZaFei);
        if (result>0 ){
            return resultModel;
        }else{
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }
}
