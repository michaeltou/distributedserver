package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.BanJi;
import com.tm.yunmo.peixun.service.BanJiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 * 班级rest接口
 */
@RestController
public class BanJiApi {

    @Autowired
    private BanJiService banJiService;

    //http://localhost:9999/queryBanJiListByInstitution?institution_code=tm
    @RequestMapping("/queryBanJiListByInstitution")
    public List<BanJi> queryBanJiListByInstitution(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        List<BanJi> banJiList = banJiService.queryBanJiListByInstitution(institution_code);
        return banJiList;
    }



    //http://localhost:9999/queryBanJiListByInstitution?institution_code=tm&kecheng_name=java%E8%AF%BE%E7%A8%8B
    @RequestMapping("/queryBanJiByName")
    public BanJi queryBanJiByName(HttpServletRequest request) {
        String school_name = request.getParameter("school_name");
        String institution_code = request.getParameter("institution_code");
        BanJi banJi = banJiService.queryBanJiByName(school_name, institution_code);
        return banJi;
    }

    /**
     * POST http://localhost:9999/insertBanJi HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 339


     {

     "id":"2",
     "banji_name":"编程1班",
     "institution_code":"tm",
     "school_name":"西可校区",
     "kecheng_name":"java课程2",
     "pre_recruit_cnt":"10",
     "student_consume_keshi":"2",
     "teacher_consume_keshi":"2",
     "note":"xxxxnote this is not",
     "teacher":"daoying",
     "assistant_teacher":"daoying",
     "status":"1"
     }

     * @param banJi
     * @return
     */
    @RequestMapping("/insertBanJi")
    public ResultModel insertBanJi(@RequestBody BanJi banJi) {
        ResultModel resultModel = new ResultModel();

        int result = banJiService.insertBanJi(banJi);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }

    }


    /**
     * POST http://localhost:9999/updateBanJi HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 343


     {

     "id":"2",
     "banji_name":"编程1班",
     "institution_code":"tm",
     "school_name":"西可校区3",
     "kecheng_name":"java课程3",
     "pre_recruit_cnt":"10",
     "student_consume_keshi":"3",
     "teacher_consume_keshi":"3",
     "note":"xxxxnote this is not3",
     "teacher":"daoying3",
     "assistant_teacher":"daoying3",
     "status":"1"
     }

     * @param banJi
     * @return
     */
    @RequestMapping("/updateBanJi")
    public ResultModel updateBanJi(@RequestBody BanJi banJi) {
        ResultModel resultModel = new ResultModel();
        int result = banJiService.updateBanJi(banJi);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }


    /**
     * POST http://localhost:9999/deleteBanJi HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 343


     {

     "id":"2",
     "banji_name":"编程1班",
     "institution_code":"tm",
     "school_name":"西可校区3",
     "kecheng_name":"java课程3",
     "pre_recruit_cnt":"10",
     "student_consume_keshi":"3",
     "teacher_consume_keshi":"3",
     "note":"xxxxnote this is not3",
     "teacher":"daoying3",
     "assistant_teacher":"daoying3",
     "status":"1"
     }

     * @param banJi
     * @return
     */
    @RequestMapping("/deleteBanJi")
    public ResultModel deleteBanJi(@RequestBody  BanJi banJi) {
        ResultModel resultModel = new ResultModel();
        int result = banJiService.deleteBanJi(banJi);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

}
