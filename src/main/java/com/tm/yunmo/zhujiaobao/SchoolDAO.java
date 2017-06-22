package com.tm.yunmo.zhujiaobao;

import com.tm.yunmo.peixun.model.School;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by jinhu on 17/6/16.
 */
@Mapper
public interface SchoolDAO {
    @Select("select id,schoolName,schoolCode,address,phone,xiaoQuCode,principalName,principalSFZCode,createDate,updateDate,type from px_school")
    List<School>  listSchoolList();

    @Insert("insert into px_school(schoolName,schoolCode,address,phone,xiaoQuCode,principalName,principalSFZCode,createDate,updateDate,type) values " +
            "(#{schoolName},#{schoolCode},#{address},#{phone},#{xiaoQuCode},#{principalName},#{principalSFZCode},now(),now(),#{type})")
    int insertSchool(@Param("schoolName") String schoolName,@Param("schoolCode") String schoolCode,@Param("address") String address,
                     @Param("phone") String phone,@Param("xiaoQuCode") String xiaoQuCode,@Param("principalName") String principalName,
                     @Param("principalSFZCode") String principalSFZCode,@Param("type")String type);

    @Delete("delete from px_school where id=#{id}")
    void deleteSchool(@Param("id") int id);


}
