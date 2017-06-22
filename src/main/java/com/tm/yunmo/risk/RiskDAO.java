package com.tm.yunmo.risk;

import com.tm.yunmo.user.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by daoying on 2017/3/15.
 */

@Mapper
public interface RiskDAO {


    @Select("select id,name,age from bigdatauser where name = #{name}")
    User findUserByName(@Param("name")String name);
    @Select("select id,name,age, identifyId ,mobilePhone ,telePhone ,bankCard ,hasCar ,hasHouse ,hasSocialSecurity ,hasHouseFund ,phoneIMEI ,blackUser " +
            " from bigdatauser where id = #{id}")
    User findUserById(@Param("id")int id );

    @Select("select id,name,age, identifyId ,mobilePhone ,telePhone ,bankCard ,hasCar ,hasHouse ,hasSocialSecurity ,hasHouseFund ,phoneIMEI ,blackUser " +
            " from bigdatauser where identifyId = #{identifyId}")
    User findUserByIdentifyId(@Param("identifyId")String identifyId );

    @Select("select id,name,age, identifyId ,mobilePhone ,telePhone ,bankCard ,hasCar ,hasHouse ,hasSocialSecurity ,hasHouseFund ,phoneIMEI ,blackUser " +
            " from bigdatauser where mobilePhone = #{mobilePhone}")
    User findUserByMobilePhone(@Param("mobilePhone")String mobilePhone );

    @Insert("insert into bigdatauser(id,name,age) "+
            "values(#{id},#{name},#{age})")
    public int insertUser(@Param("id")int id,@Param("name")String name, @Param("age")int age);

    @Update("update bigdatauser set name = #{name} ,age = #{age} where id=#{id}")
    public int updateUser(@Param("id")int id,@Param("name")String name, @Param("age")int age);


    @Delete("delete from bigdatauser where id=#{id}")
    public int deleteUser(@Param("id")int id);


}
