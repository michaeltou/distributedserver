package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.Student;
import com.tm.yunmo.peixun.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 * 学生rest接口
 */
@RestController
public class StudentApi {

    @Autowired
    private StudentService studentService;


    @RequestMapping("/queryStudentListByInstitution")
    public List<Student> queryStudentListByInstitution(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        List<Student> studentList = studentService.queryStudentListByInstitution(institution_code);
        return studentList;
    }

    //http://localhost:9999/queryStudentListBySFZCodeWithLike?institution_code=tm&sfzCode=12
    @RequestMapping("/queryStudentListBySFZCodeWithLike")
    public List<Student> queryStudentListBySFZCodeWithLike(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        String sfzCode = request.getParameter("sfzCode");
        List<Student> studentList = studentService.queryStudentListBySFZCodeWithLike(institution_code, sfzCode);
        return studentList;
    }

  //http://localhost:9999/queryStudentListByNameWithLike?institution_code=tm&name=%E6%98%8E
    @RequestMapping("/queryStudentListByNameWithLike")
    public List<Student> queryStudentListByNameWithLike(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        String name = request.getParameter("name");
        List<Student> studentList = studentService.queryStudentListByNameWithLike(institution_code, name);
        return studentList;
    }

    //http://localhost:9999/queryStudentByName?institution_code=tm&name=%E9%92%AD%E6%98%8E
    @RequestMapping("/queryStudentByName")
    public Student queryStudentByName(HttpServletRequest request) {
        String name = request.getParameter("name");
        String institution_code = request.getParameter("institution_code");
        Student student = studentService.queryStudentByName(institution_code, name);
        return student;
    }


    /**
     * POST http://localhost:9999/insertStudent HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 674

     {
     "id": 1,
     "name": "wangjianqiao",
     "sfzCode": "888829198509111011",
     "phone": "18658160158",
     "gender": "男",
     "birthday": "1985-09-11",
     "motherPhone": "18658102098",
     "fatherPhone": null,
     "address": "滨江区长虹苑",
     "email": "toudf64_43j@163.com",
     "weixinhao": "bmw10",
     "qq": "2295",
     "qudao_source": "internet",
     "header_image_url": "http://sdfsf.url",
     "current_school_level": "colleage",
     "current_school_grade": "二年级",
     "jiguan": "缙云",
     "minzu": "汉",
     "zheng_zhi_mian_miao": "群众",
     "institution_code": null,
     "createDate": null,
     "updateDate": null
     }
     * @param student
     * @return
     */
    @RequestMapping("/px/insertStudent")
    public ResultModel insertStudent(@RequestBody Student student) {
        ResultModel resultModel = new ResultModel();


        int result = studentService.insertStudent(student);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }

    }


    /**
     * POST http://localhost:9999/updateStudent HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 675

     {
     "id": 3,
     "name": "wangjianqiao2",
     "sfzCode": "888829198509111011",
     "phone": "18658160158",
     "gender": "男",
     "birthday": "1985-09-11",
     "motherPhone": "18658102098",
     "fatherPhone": null,
     "address": "滨江区长虹苑",
     "email": "toudf64_43j@163.com",
     "weixinhao": "bmw10",
     "qq": "2295",
     "qudao_source": "internet",
     "header_image_url": "http://sdfsf.url",
     "current_school_level": "colleage",
     "current_school_grade": "二年级",
     "jiguan": "缙云",
     "minzu": "汉",
     "zheng_zhi_mian_miao": "群众",
     "institution_code": null,
     "createDate": null,
     "updateDate": null
     }
     * @param student
     * @return
     */
    @RequestMapping("/updateStudent")
    public ResultModel updateStudent(@RequestBody Student student) {
        ResultModel resultModel = new ResultModel();
        int result = studentService.updateStudent(student);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }


    /**
     * POST http://localhost:9999/deleteStudent HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 674

     {
     "id": 3,
     "name": "wangjianqiao",
     "sfzCode": "888829198509111011",
     "phone": "18658160158",
     "gender": "男",
     "birthday": "1985-09-11",
     "motherPhone": "18658102098",
     "fatherPhone": null,
     "address": "滨江区长虹苑",
     "email": "toudf64_43j@163.com",
     "weixinhao": "bmw10",
     "qq": "2295",
     "qudao_source": "internet",
     "header_image_url": "http://sdfsf.url",
     "current_school_level": "colleage",
     "current_school_grade": "二年级",
     "jiguan": "缙云",
     "minzu": "汉",
     "zheng_zhi_mian_miao": "群众",
     "institution_code": "tm",
     "createDate": null,
     "updateDate": null
     }
     * @param student
     * @return
     */
    @RequestMapping("/px/deleteStudent")
    public ResultModel deleteStudent(@RequestBody Student student) {
        ResultModel resultModel = new ResultModel();
        int result = studentService.deleteStudent(student);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

}
