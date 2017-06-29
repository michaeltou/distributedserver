package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.ClassRecordDetail;
import com.tm.yunmo.peixun.service.ClassRecordDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by daoying on 2017/6/29.
 * 上课记录detail明细表 rest接口
 */
@RestController
public class ClassRecordDetailApi {

    @Autowired
    private ClassRecordDetailService classRecordDetailService;

   //http://localhost:9999/queryClassRecordDetailListByInstitutionAndMainId?institution_code=tm&main_id=1
    @RequestMapping("/queryClassRecordDetailListByInstitutionAndMainId")
    public List<ClassRecordDetail> queryClassRecordDetailListByInstitutionAndMainId(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        String main_id = request.getParameter("main_id");
        List<ClassRecordDetail> classRecordDetailList = classRecordDetailService.queryClassRecordDetailListByInstitutionAndMainId(institution_code,main_id);
        return classRecordDetailList;
    }

//http://localhost:9999/queryClassRecordDetailListByInstitutionAndBanjiNameAndStudentSfzCode?institution_code=tm&banji_name=%E8%A5%BF%E5%8F%AF%E6%A0%A1%E5%8C%BA1%E7%8F%AD&student_sfzCode=362529
    @RequestMapping("/queryClassRecordDetailListByInstitutionAndBanjiNameAndStudentSfzCode")
    public List<ClassRecordDetail> queryClassRecordDetailListByInstitutionAndBanjiNameAndStudentSfzCode(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        String banji_name = request.getParameter("banji_name");
        String student_sfzCode = request.getParameter("student_sfzCode");
        List<ClassRecordDetail> classRecordDetailList = classRecordDetailService.queryClassRecordDetailListByInstitutionAndBanjiNameAndStudentSfzCode(institution_code, banji_name,student_sfzCode);
        return classRecordDetailList;
    }

//http://localhost:9999/queryClassRecordDetailByInstitutionAndId?institution_code=tm&id=1
    @RequestMapping("/queryClassRecordDetailByInstitutionAndId")
    public ClassRecordDetail queryClassRecordDetailByInstitutionAndId(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        int id = Integer.valueOf(request.getParameter("id")).intValue();
        ClassRecordDetail classRecordDetail = classRecordDetailService.queryClassRecordDetailByInstitutionAndId(institution_code, id);
        return classRecordDetail;
    }


    /**
     * POST http://localhost:9999/insertClassRecordDetail HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 464

     {
     "id": 2,
     "main_id": "1",
     "institution_code": "tm",
     "xiaoqu_name": "西可校区",
     "banji_name": "西可校区1班",
     "student_name": "daoying2",
     "student_sfzCode": "362529",
     "kouchu_keshi": "2",
     "shangke_type": "上课",
     "jilv_zhuanzhu": 5,
     "huoyue_canyu": 3,
     "teacher_liuyan": "不错，上课认真",
     "picture_url_list": null,
     "createDate": 1483200000000,
     "updateDate": 1483200000000
     }
     * @param classRecordDetail
     * @return
     */
    @RequestMapping("/insertClassRecordDetail")
    public ResultModel insertClassRecordDetail(@RequestBody ClassRecordDetail classRecordDetail) {
        ResultModel resultModel = new ResultModel();

        int result = classRecordDetailService.insertClassRecordDetail(classRecordDetail);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }

    }


    /**
     * POST http://localhost:9999/updateClassRecordDetail HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 464

     {
     "id": 2,
     "main_id": "1",
     "institution_code": "tm",
     "xiaoqu_name": "西可校区",
     "banji_name": "西可校区1班",
     "student_name": "daoying2",
     "student_sfzCode": "362529",
     "kouchu_keshi": "3",
     "shangke_type": "旷课",
     "jilv_zhuanzhu": 5,
     "huoyue_canyu": 3,
     "teacher_liuyan": "不错，上课认真",
     "picture_url_list": null,
     "createDate": 1483200000000,
     "updateDate": 1483200000000
     }
     * @param classRecordDetail
     * @return
     */
    @RequestMapping("/updateClassRecordDetail")
    public ResultModel updateClassRecordDetail(@RequestBody ClassRecordDetail classRecordDetail) {
        ResultModel resultModel = new ResultModel();
        int result = classRecordDetailService.updateClassRecordDetail(classRecordDetail);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    /**
     * POST http://localhost:9999/deleteClassRecordDetail HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 464

     {
     "id": 2,
     "main_id": "1",
     "institution_code": "tm",
     "xiaoqu_name": "西可校区",
     "banji_name": "西可校区1班",
     "student_name": "daoying2",
     "student_sfzCode": "362529",
     "kouchu_keshi": "3",
     "shangke_type": "旷课",
     "jilv_zhuanzhu": 5,
     "huoyue_canyu": 3,
     "teacher_liuyan": "不错，上课认真",
     "picture_url_list": null,
     "createDate": 1483200000000,
     "updateDate": 1483200000000
     }
     * @param classRecordDetail
     * @return
     */
    @RequestMapping("/deleteClassRecordDetail")
    public ResultModel deleteClassRecordDetail(@RequestBody ClassRecordDetail classRecordDetail) {
        ResultModel resultModel = new ResultModel();
        int result = classRecordDetailService.deleteClassRecordDetail(classRecordDetail);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

}
