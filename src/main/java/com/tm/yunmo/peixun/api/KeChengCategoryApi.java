package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.KeChengCategory;
import com.tm.yunmo.peixun.service.KeChengCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 * 课程分类rest接口
 */
@RestController
public class KeChengCategoryApi {

    @Autowired
    private KeChengCategoryService keChengCategoryService;


    /**
     * GET http://localhost:9999/queryKeChengCategoryByInstitution?institution_code=tm HTTP/1.1
     * Host: localhost:9999
     * Content-Type: application/json;charset=UTF-8
     * Content-Length: 45
     * <p>
     * {
     * "id":5,
     * "institution_code":"tm"
     * <p>
     * }
     *
     * @param request
     * @return
     */
    @RequestMapping("/queryKeChengCategoryByInstitution")
    public List<KeChengCategory> queryKeChengCategoryByInstitution(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        List<KeChengCategory> keChengCategoryList = keChengCategoryService.queryKeChengCategoryByInstitution(institution_code);
        return keChengCategoryList;
    }


    @RequestMapping("/queryKeChengCategoryById")
    public KeChengCategory queryKeChengById(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id")).intValue();
        String institution_code = request.getParameter("institution_code");
        KeChengCategory keChengCategory = keChengCategoryService.queryKeChengCategoryById(id, institution_code);
        return keChengCategory;
    }

    @RequestMapping("/queryKeChengCategoryByName")
    public KeChengCategory queryKeChengByName(HttpServletRequest request) {
        String name = request.getParameter("name");
        String institution_code = request.getParameter("institution_code");
        KeChengCategory keChengCategory = keChengCategoryService.queryKeChengCategoryByName(name, institution_code);
        return keChengCategory;
    }


    /**
     * POST http://localhost:9999/insertKeChengCategory HTTP/1.1
     * Host: localhost:9999
     * Content-Type: application/json;charset=UTF-8
     * Content-Length: 69
     * <p>
     * {
     * "kc_category_name":"乐器类",
     * "institution_code":"tm"
     * <p>
     * }
     *
     * @param keChengCategory
     * @return
     */
    @RequestMapping("/insertKeChengCategory")
    public ResultModel insertKeChengCategory(@RequestBody KeChengCategory keChengCategory,HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        keChengCategory.setInstitution_code(institution_code);
        int result = keChengCategoryService.insertKeChengCategory(keChengCategory);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }

    }

    /**
     * POST http://localhost:9999/updateChengCategory HTTP/1.1
     * Host: localhost:9999
     * Content-Type: application/json;charset=UTF-8
     * Content-Length: 80
     * <p>
     * {
     * "id":1,
     * "kc_category_name":"乐器类",
     * "institution_code":"tm"
     * <p>
     * }
     *
     * @param keChengCategory
     * @return
     */
    @RequestMapping("/updateChengCategory")
    public ResultModel updateChengCategory(@RequestBody KeChengCategory keChengCategory) {
        ResultModel resultModel = new ResultModel();
        int result = keChengCategoryService.updateChengCategory(keChengCategory);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    /**
     * POST http://localhost:9999/deleteChengCategory HTTP/1.1
     * Host: localhost:9999
     * Content-Type: application/json;charset=UTF-8
     * Content-Length: 45
     * <p>
     * {
     * "id":5,
     * "institution_code":"tm"
     * <p>
     * }
     *
     * @param keChengCategory
     * @return
     */
    @RequestMapping("/deleteChengCategory")
    public ResultModel deleteChengCategory(@RequestBody KeChengCategory keChengCategory,HttpServletRequest request) {
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        keChengCategory.setInstitution_code(institution_code);
        ResultModel resultModel = new ResultModel();
        int result = keChengCategoryService.deleteChengCategory(keChengCategory);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    @RequestMapping("/queryKeChengCategoryListByNameWithLike")
    public ResultModel queryKeChengCategoryListByNameWithLike( HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        String kc_category_name = request.getParameter("kc_category_name");
        List<KeChengCategory> keChengCategoryList = keChengCategoryService.queryKeChengCategoryByNameWithLike(kc_category_name, institution_code);

        resultModel.setData(keChengCategoryList);
        return resultModel;
    }
}
