package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.School;
import com.tm.yunmo.peixun.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 * 学校rest接口
 */
@RestController
public class SchoolApi {

    @Autowired
    private SchoolService schoolService;


    /**
     * http://localhost:9999/querySchoolListByInstitution?institution_code=tm
     * @param request
     * @return
     */
    @RequestMapping("/querySchoolListByInstitution")
    public List<School> querySchoolListByInstitution(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        List<School> schoolList = schoolService.querySchoolListByInstitution(institution_code);
        return schoolList;
    }

    /**
     * http://localhost:9999/querySchoolById?institution_code=tm&id=1
     * @param request
     * @return
     */
    @RequestMapping("/querySchoolById")
    public School querySchoolById(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id")).intValue();
        String institution_code = request.getParameter("institution_code");
        School school = schoolService.querySchoolById(id, institution_code);
        return school;
    }

    //http://localhost:9999/querySchoolByName?institution_code=tm&school_name=%E8%A5%BF%E6%B9%96%E6%A0%A1%E5%8C%BA
    @RequestMapping("/querySchoolByName")
    public School querySchoolByName(HttpServletRequest request) {
        String school_name = request.getParameter("school_name");
        String institution_code = request.getParameter("institution_code");
        School school = schoolService.querySchoolByName(school_name, institution_code);
        return school;
    }


    /**
     *
     * POST http://localhost:9999/insertSchool HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 186

     {

     "school_name":"西可校区",
     "institution_code":"tm",
     "address":"秋溢路",
     "phone":"135",
     "principal_name":"daoying" ,
     "principal_sfz_code":"362529",
     "type":"zhiying"
     }

     * @param school
     * @return
     */
    @RequestMapping("/px/insertSchool")
    public ResultModel insertSchool(@RequestBody School school) {
        ResultModel resultModel = new ResultModel();

        int result = schoolService.insertSchool(school);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }

    }


    /**
     * POST http://localhost:9999/updateSchool HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 196

     {
     "id":3,
     "school_name":"西可校区",
     "institution_code":"tm",
     "address":"秋溢路222",
     "phone":"135",
     "principal_name":"daoying" ,
     "principal_sfz_code":"362529",
     "type":"zhiying"
     }

     * @param school
     * @return
     */
    @RequestMapping("/px/updateSchool")
    public ResultModel updateSchool(@RequestBody School school) {
        ResultModel resultModel = new ResultModel();
        int result = schoolService.updateSchool(school);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    /**
     * POST http://localhost:9999/deleteSchool HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 196

     {
     "id":3,
     "school_name":"西可校区",
     "institution_code":"tm",
     "address":"秋溢路222",
     "phone":"135",
     "principal_name":"daoying" ,
     "principal_sfz_code":"362529",
     "type":"zhiying"
     }

     * @param school
     * @return
     */
    @RequestMapping("/px/deleteSchool")
    public ResultModel deleteSchool(@RequestBody School school) {
        ResultModel resultModel = new ResultModel();
        int result = schoolService.deleteSchool(school);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

}
