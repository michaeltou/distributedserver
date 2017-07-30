package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.Role;
import com.tm.yunmo.peixun.model.UserPictures;
import com.tm.yunmo.peixun.service.RoleService;
import com.tm.yunmo.peixun.service.UserPicturesService;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by daoying on 2017/7/30.
 * 用户上传rest接口
 */
@RestController
public class UserPicturesApi {

    @Autowired
    private UserPicturesService userPicturesService;



    @RequestMapping("/insertUserPictures")
    public ResultModel insertRole(@RequestBody UserPictures userPictures,HttpServletRequest request) {

        String institution_code = (String) request.getSession().getAttribute("institution_code");
        String sfzCode = (String) request.getSession().getAttribute("sfzCode");


        ResultModel resultModel = new ResultModel();

        String url2 =userPictures.getUrl2();
        if (url2==null || "".equals(url2)){
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }

        String[] urlArray = url2.split(",");
        if (urlArray.length == 0){
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }

        for (int i =0;i<urlArray.length;i++)  {
          String   url = urlArray[i];
            userPictures.setPicture_name(url);
            userPictures.setInstitution_code(institution_code);
            userPictures.setUsername(sfzCode);

            int result = userPicturesService.insertUserPictures(userPictures);
            if (result > 0) {
                continue;
            } else {
                resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
                return resultModel;
            }
        }

         return resultModel;

    }




}
