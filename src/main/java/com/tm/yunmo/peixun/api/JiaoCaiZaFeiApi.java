package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.JiaoCaiZaFei;
import com.tm.yunmo.peixun.service.JiaoCaiZaFeiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 * 教材杂费rest接口
 */
@RestController
public class JiaoCaiZaFeiApi {

    @Autowired
    private JiaoCaiZaFeiService jiaoCaiZaFeiService;


    /**
     * http://localhost:9999/queryJiaoCaiZaFeiListByInstitution?institution_code=tm
     * @param request
     * @return
     */
    @RequestMapping("/queryJiaoCaiZaFeiListByInstitution")
    public List<JiaoCaiZaFei> queryJiaoCaiZaFeiListByInstitution(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        List<JiaoCaiZaFei> jiaoCaiZaFeiList = jiaoCaiZaFeiService.queryJiaoCaiZaFeiListByInstitution(institution_code);
        return jiaoCaiZaFeiList;
    }

   //http://localhost:9999/queryJiaoCaiZaFeiById?institution_code=tm&id=1
    @RequestMapping("/queryJiaoCaiZaFeiById")
    public JiaoCaiZaFei queryJiaoCaiZaFeiById(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id")).intValue();
        String institution_code = request.getParameter("institution_code");
        JiaoCaiZaFei jiaoCaiZaFei = jiaoCaiZaFeiService.queryJiaoCaiZaFeiById(id, institution_code);
        return jiaoCaiZaFei;
    }


    /**
     * POST http://localhost:9999/insertJiaoCaiZaFei HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 236

     {
     "id": 2,
     "name": "跳舞衣服2",
     "jin_jia": 200,
     "sou_jia": 400,
     "kecheng_category": "舞蹈类2",
     "jifeng_duihuang": 0,
     "institution_code": "tm",
     "createDate": null,
     "updateDate": null
     }
     * @param jiaoCaiZaFei
     * @return
     */
    @RequestMapping("/insertJiaoCaiZaFei")
    public ResultModel insertJiaoCaiZaFei(@RequestBody JiaoCaiZaFei jiaoCaiZaFei) {
        ResultModel resultModel = new ResultModel();

        int result = jiaoCaiZaFeiService.insertJiaoCaiZaFei(jiaoCaiZaFei);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    /**
     * POST http://localhost:9999/updateJiaoCaiZaFei HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 236

     {
     "id": 2,
     "name": "跳舞衣服2",
     "jin_jia": 200,
     "sou_jia": 400,
     "kecheng_category": "舞蹈类3",
     "jifeng_duihuang": 0,
     "institution_code": "tm",
     "createDate": null,
     "updateDate": null
     }
     * @param jiaoCaiZaFei
     * @return
     */
    @RequestMapping("/updateJiaoCaiZaFei")
    public ResultModel updateJiaoCaiZaFei(@RequestBody JiaoCaiZaFei jiaoCaiZaFei) {
        ResultModel resultModel = new ResultModel();
        int result = jiaoCaiZaFeiService.updateJiaoCaiZaFei(jiaoCaiZaFei);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }


    /**
     * POST http://localhost:9999/deleteJiaoCaiZaFei HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 236

     {
     "id": 2,
     "name": "跳舞衣服2",
     "jin_jia": 200,
     "sou_jia": 400,
     "kecheng_category": "舞蹈类3",
     "jifeng_duihuang": 0,
     "institution_code": "tm",
     "createDate": null,
     "updateDate": null
     }
     * @param jiaoCaiZaFei
     * @return
     */
    @RequestMapping("/deleteJiaoCaiZaFei")
    public ResultModel deleteJiaoCaiZaFei(@RequestBody JiaoCaiZaFei jiaoCaiZaFei) {
        ResultModel resultModel = new ResultModel();
        int result = jiaoCaiZaFeiService.deleteJiaoCaiZaFei(jiaoCaiZaFei);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

}
