package com.tm.yunmo.datacenter;

import com.tm.yunmo.user.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by daoying on 2017/3/14.
 */
@Mapper
public interface DataCenterDao {

    @Select("select id,name,age from user where name = #{name}")
    User findUserByName(@Param("name")String name);


    @Insert("insert into user(id,name,age) "+
            "values(#{id},#{name},#{age})")
    public int insertUser(@Param("id")int id,@Param("name")String name, @Param("age")int age);

    @Update("update user set name = #{name} ,age = #{age} where id=#{id}")
    public int updateUser(@Param("id")int id,@Param("name")String name, @Param("age")int age);


    @Delete("delete from user where id=#{id}")
    public int deleteUser(@Param("id")int id);
}
