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
 */
@RestController
public class SchoolApi {

    @Autowired
    private SchoolService schoolService;


    @RequestMapping("/querySchoolListByInstitution")
    public List<School> querySchoolListByInstitution(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        List<School> schoolList = schoolService.querySchoolListByInstitution(institution_code);
        return schoolList;
    }

    @RequestMapping("/querySchoolById")
    public School querySchoolById(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id")).intValue();
        String institution_code = request.getParameter("institution_code");
        School school = schoolService.querySchoolById(id, institution_code);
        return school;
    }

    @RequestMapping("/querySchoolByName")
    public School querySchoolByName(HttpServletRequest request) {
        String school_name = request.getParameter("school_name");
        String institution_code = request.getParameter("institution_code");
        School school = schoolService.querySchoolByName(school_name, institution_code);
        return school;
    }


    @RequestMapping("/insertSchool")
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


    @RequestMapping("/updateSchool")
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

    @RequestMapping("/deleteSchool")
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
