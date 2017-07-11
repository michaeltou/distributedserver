package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.KeCheng;
import com.tm.yunmo.peixun.model.KeChengChargeInfo;
import com.tm.yunmo.peixun.model.KeChengComposeModel;
import com.tm.yunmo.peixun.service.KeChengChargeInfoService;
import com.tm.yunmo.peixun.service.KeChengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 * 课程rest接口
 */
@Transactional
@RestController
public class KeChengApi {

    @Autowired
    private KeChengService keChengService;



    @Autowired
    private KeChengChargeInfoService keChengChargeInfoService;

    /**
     * http://localhost:9999/queryKeChengListByInstitution?institution_code=tm
     * @param request
     * @return
     */
    @RequestMapping("/queryKeChengListByInstitution")
    public List<KeCheng> queryKeChengListByInstitution(HttpServletRequest request){
        String institution_code =  request.getParameter("institution_code");
        List<KeCheng> keChengList = keChengService.queryKeChengListByInstitution( institution_code);
        return keChengList;
    }

    /**
     * http://localhost:9999/queryKeChengByName?institution_code=tm&name=%E6%8B%89%E4%B8%81%E8%88%9E
     * @param request
     * @return
     */
    @RequestMapping("/queryKeChengByName")
    public KeCheng queryKeChengByName(HttpServletRequest request){
        String name =  request.getParameter("name");
        String institution_code =  request.getParameter("institution_code");
        KeCheng keCheng = keChengService.queryKeChengByName(name, institution_code);
        return keCheng;
    }

    /**
     * POST http://localhost:9999/insertKeChengChargeInfo HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 209

     {
     "kecheng_name":"舞蹈",
     "chargeType": " type_year",
     "chargeFee": 20000,
     "status": "1 ",
     "institution_code":"tm",
     "createDate": "2017-06-22T12:01:00.000Z",
     "updateDate": "2017-06-22T12:01:00.000Z"
     }
     * @param keCheng
     * @return
     */
    @RequestMapping("/insertKeCheng")
    public ResultModel insertKeCheng(@RequestBody KeCheng keCheng,HttpServletRequest request) {
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        keCheng.setInstitution_code(institution_code);

        ResultModel resultModel = new ResultModel();

        int result =   keChengService.insertKeCheng(keCheng);
        if (result>0 ){
            return resultModel;
        }else{
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }


    @RequestMapping("/insertKeChengAndChargeInfo")
    public ResultModel insertKeChengAndChargeInfo(@RequestBody KeChengComposeModel keChengComposeModel, HttpServletRequest request) {
        String institution_code = (String) request.getSession().getAttribute("institution_code");

        KeCheng keCheng = new KeCheng();
        keCheng.setInstitution_code(institution_code);
        keCheng.setName(keChengComposeModel.getName());
        keCheng.setKc_category_name(keChengComposeModel.getKc_category_name());
        keCheng.setNote(keChengComposeModel.getNote());
        keCheng.setOpenSchoolNameList(keChengComposeModel.getOpenSchoolNameList());
        keCheng.setStatus("1");
        //创建课程基本信息
        int result1 =   keChengService.insertKeCheng(keCheng);


        KeChengChargeInfo keChengChargeInfo = new KeChengChargeInfo();
        keChengChargeInfo.setKecheng_name(keChengComposeModel.getName());
        keChengChargeInfo.setChargeType(keChengComposeModel.getChargeType());
        keChengChargeInfo.setChargeFee(keChengComposeModel.getChargeFee());
        keChengChargeInfo.setInstitution_code(institution_code);
        keChengChargeInfo.setStatus("1");
        //创建课程的收费信息.
        int result2 =  keChengChargeInfoService.insertKeChengChargeInfo(keChengChargeInfo);

        ResultModel resultModel = new ResultModel();
        if (result1>0 && result2>0 ){
            return resultModel;
        }else{
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    /**
     * 更新课程信息和收费信息
     * @param keCheng
     * @param request
     * @return
     */
    @RequestMapping("/updateKeChengComposeChargeInfo")
    public ResultModel updateKeChengComposeChargeInfo(@RequestBody KeChengComposeModel keChengComposeModel,HttpServletRequest request) {
        String institution_code = (String) request.getSession().getAttribute("institution_code");

        KeCheng keCheng = new KeCheng();
        keCheng.setInstitution_code(institution_code);
        keCheng.setName(keChengComposeModel.getName());
        keCheng.setKc_category_name(keChengComposeModel.getKc_category_name());
        keCheng.setNote(keChengComposeModel.getNote());
        keCheng.setOpenSchoolNameList(keChengComposeModel.getOpenSchoolNameList());
        keCheng.setStatus("1");
        //更新课程基本信息
        int result1 =   keChengService.updateKeCheng(keCheng);

        KeChengChargeInfo keChengChargeInfo = new KeChengChargeInfo();
        keChengChargeInfo.setKecheng_name(keChengComposeModel.getName());
        keChengChargeInfo.setChargeType(keChengComposeModel.getChargeType());
        keChengChargeInfo.setChargeFee(keChengComposeModel.getChargeFee());
        keChengChargeInfo.setInstitution_code(institution_code);
        keChengChargeInfo.setStatus("1");
        //更新课程的收费信息.
        int result2 =  keChengChargeInfoService.updateKeChengChargeInfo(keChengChargeInfo);

        ResultModel resultModel = new ResultModel();
        if (result1>0 && result2 > 0){
            return resultModel;
        }else{
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }


    /**
     * POST http://localhost:9999/updateKeCheng HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 179

     {
     "name":"拉丁舞",
     "kc_category_name":"舞蹈类2"
     ,
     "note":"拉丁舞蹈2"
     ,
     "status":"0",
     "openSchoolNameList":"西可校区,西湖校区",
     "institution_code":"tm"
     }
     * @param keCheng
     * @return
     */
    @RequestMapping("/updateKeCheng")
    public ResultModel updateKeCheng(@RequestBody KeCheng keCheng,HttpServletRequest request) {
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        keCheng.setInstitution_code(institution_code);
        ResultModel resultModel = new ResultModel();

        int result =   keChengService.updateKeCheng(keCheng);
        if (result>0 ){
            return resultModel;
        }else{
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }


    /**
     * POST http://localhost:9999/insertKeChengChargeInfo HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 209

     {
     "kecheng_name":"舞蹈",
     "chargeType": " type_year",
     "chargeFee": 20000,
     "status": "1 ",
     "institution_code":"tm",
     "createDate": "2017-06-22T12:01:00.000Z",
     "updateDate": "2017-06-22T12:01:00.000Z"
     }
     * @param keCheng
     * @return
     */
    @RequestMapping("/deleteKeCheng")
    public ResultModel deleteKeCheng(@RequestBody KeCheng keCheng,HttpServletRequest request) {
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        keCheng.setInstitution_code(institution_code);
        ResultModel resultModel = new ResultModel();
        //删除课程信息.
        int result1 =   keChengService.deleteKeCheng(keCheng);


        KeChengChargeInfo keChengChargeInfo = new KeChengChargeInfo();
        keChengChargeInfo.setInstitution_code(institution_code);
        keChengChargeInfo.setKecheng_name(keCheng.getName());
        //删除课程的收费信息.
        int result2 =  keChengChargeInfoService.deleteKeChengChargeInfoByKeChengName(keChengChargeInfo);


        if (result1>0 && result2>0 ){
            return resultModel;
        }else{
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }



    @RequestMapping("/queryKeChengListWithNameLike")
    public ResultModel queryKeChengListWithNameLike( HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        String name = request.getParameter("name");
        List<KeCheng> keChengList = keChengService.queryKeChengListWithNameLike(name, institution_code);

        resultModel.setData(keChengList);
        return resultModel;
    }
}
