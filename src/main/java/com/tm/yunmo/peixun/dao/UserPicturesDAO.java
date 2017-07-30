package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.UserPictures;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by daoying on 2017/7/29
 * 用户图片表dao.
 */

@Mapper
public interface UserPicturesDAO {

    @Select("  SELECT `px_user_pictures`.`id`,\n" +
            "    `px_user_pictures`.`username`,\n" +
            "    `px_user_pictures`.`banji_name`,\n" +
            "    `px_user_pictures`.`picture_name`,\n" +
            "    `px_user_pictures`.`createDate`,\n" +
            "    `px_user_pictures`.`updateDate`\n" +
            "FROM  `px_user_pictures` " +
            " where  institution_code = #{institution_code} and username=#{username}  and banji_name = #{banji_name} ")
    List<UserPictures> queryUserPicturesByUserNameAndBanJiName(@Param("institution_code") String institution_code, @Param("username") String username, @Param("banji_name") String banji_name);


    @Insert("  INSERT INTO  `px_user_pictures`\n" +
            "( \n" +
            "`username`,\n" +
            "`banji_name`,\n" +
            "`picture_name`,\n" +
            "`createDate`,\n" +
            "`updateDate`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{username},\n" +
            "#{banji_name},\n" +
            "#{picture_name},\n" +
            "now(),\n" +
            "now());"    )
    public int insertUserPictures(UserPictures userPictures);

    @Delete(" DELETE FROM  `px_user_pictures`\n" +
            "WHERE   institution_code=#{institution_code} and id=#{id} \n "
           )
    public int deleteUserPictures(UserPictures userPictures);


}
