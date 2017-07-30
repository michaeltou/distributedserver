package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.UserPicturesDAO;
import com.tm.yunmo.peixun.model.UserPictures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 * 用户角色service类.
 */
@Component
public class UserPicturesService {

    @Autowired
    private UserPicturesDAO userPicturesDAO;

    public List<UserPictures> queryUserPicturesByUserNameAndBanJiName(String institution_code, String username,String banji_name) {
        List<UserPictures> userPicturesList = userPicturesDAO.queryUserPicturesByUserNameAndBanJiName(institution_code, username,banji_name);
        return userPicturesList;
    }

    public List<UserPictures> queryUserPicturesByUserName(String institution_code, String username ) {
        List<UserPictures> userPicturesList = userPicturesDAO.queryUserPicturesByUserName(institution_code, username );
        return userPicturesList;
    }

    public int insertUserPictures(UserPictures userPictures) {
        int result = userPicturesDAO.insertUserPictures(userPictures);
        return result;
    }


    public int deleteUserPictures(UserPictures userPictures) {
        int result = userPicturesDAO.deleteUserPictures(userPictures);
        return result;
    }



}
