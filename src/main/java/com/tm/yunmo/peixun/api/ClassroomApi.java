package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.Classroom;
import com.tm.yunmo.peixun.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 * 教室rest接口
 */
@RestController
public class ClassroomApi {

    @Autowired
    private ClassroomService classroomService;


    //http://localhost:9999/queryClassroomListByInstitutionAndSchoolName?institution_code=tm&school_name=%E8%A5%BF%E5%8F%AF%E6%A0%A1%E5%8C%BA
    @RequestMapping("/queryClassroomListByInstitutionAndSchoolName")
    public List<Classroom> queryClassroomListByInstitutionAndSchoolName(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        String school_name = request.getParameter("school_name");
        List<Classroom> classroomList = classroomService.queryClassroomListByInstitutionAndSchoolName(institution_code,school_name);
        return classroomList;
    }



   //http://localhost:9999/queryClassroomByName?institution_code=tm&school_name=%E8%A5%BF%E5%8F%AF%E6%A0%A1%E5%8C%BA&name=%E6%95%99%E5%AE%A41
    @RequestMapping("/queryClassroomByName")
    public Classroom queryClassroomByName(HttpServletRequest request) {
        String school_name = request.getParameter("school_name");
        String institution_code = request.getParameter("institution_code");
        String name = request.getParameter("name");
        Classroom classroom = classroomService.queryClassroomByName(institution_code,school_name,name );
        return classroom;
    }

    /**
     * POST http://localhost:9999/insertClassroom HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 174

     {
     "id":"2",
     "name":"教室2",
     "school_name":"西可校区",
     "institution_code":"tm",
     "capacity":"8",
     "address":"秋溢路",
     "picUrl":"xxxxx",
     "note":"thisisnote"
     }

     * @param classroom
     * @return
     */
    @RequestMapping("/insertClassroom")
    public ResultModel insertClassroom(@RequestBody Classroom classroom) {
        ResultModel resultModel = new ResultModel();

        int result = classroomService.insertClassroom(classroom);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }

    }


    /**
     * POST http://localhost:9999/updateClassroom HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 176

     {
     "id":"2",
     "name":"教室2",
     "school_name":"西可校区",
     "institution_code":"tm",
     "capacity":"10",
     "address":"秋溢路2",
     "picUrl":"xxxxx",
     "note":"thisisnote"
     }

     * @param classroom
     * @return
     */
    @RequestMapping("/updateClassroom")
    public ResultModel updateClassroom(@RequestBody Classroom classroom) {
        ResultModel resultModel = new ResultModel();
        int result = classroomService.updateClassroom(classroom);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }


    /**
     *
     * POST http://localhost:9999/deleteClassroom HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 176

     {
     "id":"2",
     "name":"教室2",
     "school_name":"西可校区",
     "institution_code":"tm",
     "capacity":"10",
     "address":"秋溢路2",
     "picUrl":"xxxxx",
     "note":"thisisnote"
     }
     * @param classroom
     * @return
     */
    @RequestMapping("/deleteClassroom")
    public ResultModel deleteClassroom(@RequestBody  Classroom classroom) {
        ResultModel resultModel = new ResultModel();
        int result = classroomService.deleteClassroom(classroom);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

}
