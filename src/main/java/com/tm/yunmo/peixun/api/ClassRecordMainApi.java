package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.ClassRecordMain;
import com.tm.yunmo.peixun.service.ClassRecordMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by daoying on 2017/6/29.
 * 上课记录主表 rest接口
 */
@RestController
public class ClassRecordMainApi {

    @Autowired
    private ClassRecordMainService classRecordMainService;

   //http://localhost:9999/queryClassRecordMainListByInstitution?institution_code=tm
    @RequestMapping("/queryClassRecordMainListByInstitution")
    public List<ClassRecordMain> queryClassRecordMainListByInstitution(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        List<ClassRecordMain> classRecordMainList = classRecordMainService.queryClassRecordMainListByInstitution(institution_code);
        return classRecordMainList;
    }

    //http://localhost:9999/queryClassRecordMainListByInstitutionAndXiaoquName?institution_code=tm&xiaoqu_name=%E8%A5%BF%E5%8F%AF%E6%A0%A1%E5%8C%BA
    @RequestMapping("/queryClassRecordMainListByInstitutionAndXiaoquName")
    public List<ClassRecordMain> queryClassRecordMainListByInstitutionAndXiaoquName(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        String xiaoqu_name = request.getParameter("xiaoqu_name");
        List<ClassRecordMain> classRecordMainList = classRecordMainService.queryClassRecordMainListByInstitutionAndXiaoquName(institution_code, xiaoqu_name);
        return classRecordMainList;
    }

    //http://localhost:9999/queryClassRecordMainListByInstitutionAndBanjiName?institution_code=tm&banji_name=%E8%A5%BF%E5%8F%AF%E6%A0%A1%E5%8C%BA1%E7%8F%AD
    @RequestMapping("/queryClassRecordMainListByInstitutionAndBanjiName")
    public List<ClassRecordMain> queryClassRecordMainListByInstitutionAndBanjiName(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        String banji_name = request.getParameter("banji_name");
        List<ClassRecordMain> classRecordMainList = classRecordMainService.queryClassRecordMainListByInstitutionAndBanjiName(institution_code, banji_name);
        return classRecordMainList;
    }

    //http://localhost:9999/queryClassRecordMainListByInstitutionAndBanjiNameWithBanjiNameLike?institution_code=tm&banji_name=%E8%A5%BF%E5%8F%AF%E6%A0%A1%E5%8C%BA1%E7%8F%AD
    @RequestMapping("/queryClassRecordMainListByInstitutionAndBanjiNameWithBanjiNameLike")
    public List<ClassRecordMain> queryClassRecordMainListByInstitutionAndBanjiNameWithBanjiNameLike(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        String banji_name = request.getParameter("banji_name");
        List<ClassRecordMain> classRecordMainList = classRecordMainService.queryClassRecordMainListByInstitutionAndBanjiName(institution_code, banji_name);
        return classRecordMainList;
    }



    //http://localhost:9999/queryClassRecordMainByInstitutionAndId?institution_code=tm&id=1
    @RequestMapping("/queryClassRecordMainByInstitutionAndId")
    public ClassRecordMain queryClassRecordMainByInstitutionAndId(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id")).intValue();
        String institution_code = request.getParameter("institution_code");
        ClassRecordMain classRecordMain = classRecordMainService.queryClassRecordMainByInstitutionAndId(institution_code, id);
        return classRecordMain;
    }


    /**
     * POST http://localhost:9999/insertClassRecordMain HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 655

     {
     "id": 1,
     "banji_name": "西可校区1班",
     "institution_code": "tm",
     "xiaoqu_name": "西可校区",
     "shangke_start_date": 1483200000000,
     "shangke_end_date": 1483200000000,
     "jiaoshi_keshi": 2,
     "teacher_name": "钭明",
     "teacher_sfzCode": "362529",
     "assist_teacher_name": "张三",
     "assist_teacher_sfzCode": "42000000",
     "shangke_content": "这是一节跳舞课，学生都很女里",
     "shangke_note": "课程备注内容",
     "shangke_pic_list": null,
     "creator_username": "daoying",
     "creator_name": "刀影",
     "createDate": 1483200000000,
     "updateDate": 1483200000000
     }
     * @param classRecordMain
     * @return
     */
    @RequestMapping("/insertClassRecordMain")
    public ResultModel insertClassRecordMain(@RequestBody ClassRecordMain classRecordMain) {
        ResultModel resultModel = new ResultModel();

        int result = classRecordMainService.insertClassRecordMain(classRecordMain);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }

    }


    /**
     * POST http://localhost:9999/updateClassRecordMain HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 654

     {
     "id":8,
     "banji_name": "西可校区1班",
     "institution_code": "tm",
     "xiaoqu_name": "西可校区",
     "shangke_start_date": 1483200000000,
     "shangke_end_date": 1483200000000,
     "jiaoshi_keshi": 3,
     "teacher_name": "钭明",
     "teacher_sfzCode": "362529",
     "assist_teacher_name": "张三",
     "assist_teacher_sfzCode": "42000000",
     "shangke_content": "这是一节跳舞课，学生都很女里",
     "shangke_note": "课程备注内容",
     "shangke_pic_list": null,
     "creator_username": "daoying",
     "creator_name": "刀影",
     "createDate": 1483200000000,
     "updateDate": 1483200000000
     }
     * @param classRecordMain
     * @return
     */
    @RequestMapping("/updateClassRecordMain")
    public ResultModel updateClassRecordMain(@RequestBody ClassRecordMain classRecordMain) {
        ResultModel resultModel = new ResultModel();
        int result = classRecordMainService.updateClassRecordMain(classRecordMain);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }


    /**
     * POST http://localhost:9999/deleteClassRecordMain HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 654

     {
     "id":8,
     "banji_name": "西可校区1班",
     "institution_code": "tm",
     "xiaoqu_name": "西可校区",
     "shangke_start_date": 1483200000000,
     "shangke_end_date": 1483200000000,
     "jiaoshi_keshi": 3,
     "teacher_name": "钭明",
     "teacher_sfzCode": "362529",
     "assist_teacher_name": "张三",
     "assist_teacher_sfzCode": "42000000",
     "shangke_content": "这是一节跳舞课，学生都很女里",
     "shangke_note": "课程备注内容",
     "shangke_pic_list": null,
     "creator_username": "daoying",
     "creator_name": "刀影",
     "createDate": 1483200000000,
     "updateDate": 1483200000000
     }
     * @param classRecordMain
     * @return
     */
    @RequestMapping("/deleteClassRecordMain")
    public ResultModel deleteClassRecordMain(@RequestBody ClassRecordMain classRecordMain) {
        ResultModel resultModel = new ResultModel();
        int result = classRecordMainService.deleteClassRecordMain(classRecordMain);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

}
