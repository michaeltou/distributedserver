package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by daoying on 2017/3/15.
 * 员工dao.
 */

@Mapper
public interface EmployeeDAO {


    @Select(" SELECT `px_employee`.`id`,\n" +
            "    `px_employee`.`name`,\n" +
            "    `px_employee`.`phone`,\n" +
            "    `px_employee`.`sfzCode`,\n" +
            "    `px_employee`.`institution_code`,\n" +
            "    `px_employee`.`xiaoqu_name`,\n" +
            "    `px_employee`.`gender`,\n" +
            "    `px_employee`.`birthday`,\n" +
            "    `px_employee`.`english_name`,\n" +
            "    `px_employee`.`email`,\n" +
            "    `px_employee`.`ji_guan`,\n" +
            "    `px_employee`.`nationality`,\n" +
            "    `px_employee`.`zhengzhi_mianmao`,\n" +
            "    `px_employee`.`is_married`,\n" +
            "    `px_employee`.`biye_yuanxiao`,\n" +
            "    `px_employee`.`zhuanye`,\n" +
            "    `px_employee`.`xueli`,\n" +
            "    `px_employee`.`peixun_jingli`,\n" +
            "    `px_employee`.`renshi_zhuangtai`,\n" +
            "    `px_employee`.`employ_start_date`,\n" +
            "    `px_employee`.`employ_end_date`,\n" +
            "    `px_employee`.`laodong_guanxi`,\n" +
            "    `px_employee`.`zhuanzheng_date`,\n" +
            "    `px_employee`.`bank_card`,\n" +
            "    `px_employee`.`bank`,\n" +
            "    `px_employee`.`create_date`,\n" +
            "    `px_employee`.`update_date`\n" +
            " FROM  `px_employee`  \n" +
            " where  institution_code = #{institution_code} ")
    List<Employee> queryEmployeeListByInstitution(@Param("institution_code") String institution_code);



    @Select(" SELECT `px_employee`.`id`,\n" +
            "    `px_employee`.`name`,\n" +
            "    `px_employee`.`phone`,\n" +
            "    `px_employee`.`sfzCode`,\n" +
            "    `px_employee`.`institution_code`,\n" +
            "    `px_employee`.`xiaoqu_name`,\n" +
            "    `px_employee`.`gender`,\n" +
            "    `px_employee`.`birthday`,\n" +
            "    `px_employee`.`english_name`,\n" +
            "    `px_employee`.`email`,\n" +
            "    `px_employee`.`ji_guan`,\n" +
            "    `px_employee`.`nationality`,\n" +
            "    `px_employee`.`zhengzhi_mianmao`,\n" +
            "    `px_employee`.`is_married`,\n" +
            "    `px_employee`.`biye_yuanxiao`,\n" +
            "    `px_employee`.`zhuanye`,\n" +
            "    `px_employee`.`xueli`,\n" +
            "    `px_employee`.`peixun_jingli`,\n" +
            "    `px_employee`.`renshi_zhuangtai`,\n" +
            "    `px_employee`.`employ_start_date`,\n" +
            "    `px_employee`.`employ_end_date`,\n" +
            "    `px_employee`.`laodong_guanxi`,\n" +
            "    `px_employee`.`zhuanzheng_date`,\n" +
            "    `px_employee`.`bank_card`,\n" +
            "    `px_employee`.`bank`,\n" +
            "    `px_employee`.`create_date`,\n" +
            "    `px_employee`.`update_date`\n" +
            " FROM  `px_employee`  \n" +
            " where  institution_code = #{institution_code} and sfzCode like  CONCAT('%',#{sfzCode},'%')   ")
    List<Employee> queryEmployeeListBySFZCodeWithLike(@Param("institution_code") String institution_code, @Param("sfzCode") String sfzCode);


    @Select(" SELECT `px_employee`.`id`,\n" +
            "    `px_employee`.`name`,\n" +
            "    `px_employee`.`phone`,\n" +
            "    `px_employee`.`sfzCode`,\n" +
            "    `px_employee`.`institution_code`,\n" +
            "    `px_employee`.`xiaoqu_name`,\n" +
            "    `px_employee`.`gender`,\n" +
            "    `px_employee`.`birthday`,\n" +
            "    `px_employee`.`english_name`,\n" +
            "    `px_employee`.`email`,\n" +
            "    `px_employee`.`ji_guan`,\n" +
            "    `px_employee`.`nationality`,\n" +
            "    `px_employee`.`zhengzhi_mianmao`,\n" +
            "    `px_employee`.`is_married`,\n" +
            "    `px_employee`.`biye_yuanxiao`,\n" +
            "    `px_employee`.`zhuanye`,\n" +
            "    `px_employee`.`xueli`,\n" +
            "    `px_employee`.`peixun_jingli`,\n" +
            "    `px_employee`.`renshi_zhuangtai`,\n" +
            "    `px_employee`.`employ_start_date`,\n" +
            "    `px_employee`.`employ_end_date`,\n" +
            "    `px_employee`.`laodong_guanxi`,\n" +
            "    `px_employee`.`zhuanzheng_date`,\n" +
            "    `px_employee`.`bank_card`,\n" +
            "    `px_employee`.`bank`,\n" +
            "    `px_employee`.`create_date`,\n" +
            "    `px_employee`.`update_date`\n" +
            " FROM  `px_employee`  \n" +
            " where  institution_code = #{institution_code} and name like CONCAT('%',#{name},'%') ")
    List<Employee> queryEmployeeListByNameWithLike(@Param("institution_code") String institution_code, @Param("name") String name);

    @Select(" SELECT `px_employee`.`id`,\n" +
            "    `px_employee`.`name`,\n" +
            "    `px_employee`.`phone`,\n" +
            "    `px_employee`.`sfzCode`,\n" +
            "    `px_employee`.`institution_code`,\n" +
            "    `px_employee`.`xiaoqu_name`,\n" +
            "    `px_employee`.`gender`,\n" +
            "    `px_employee`.`birthday`,\n" +
            "    `px_employee`.`english_name`,\n" +
            "    `px_employee`.`email`,\n" +
            "    `px_employee`.`ji_guan`,\n" +
            "    `px_employee`.`nationality`,\n" +
            "    `px_employee`.`zhengzhi_mianmao`,\n" +
            "    `px_employee`.`is_married`,\n" +
            "    `px_employee`.`biye_yuanxiao`,\n" +
            "    `px_employee`.`zhuanye`,\n" +
            "    `px_employee`.`xueli`,\n" +
            "    `px_employee`.`peixun_jingli`,\n" +
            "    `px_employee`.`renshi_zhuangtai`,\n" +
            "    `px_employee`.`employ_start_date`,\n" +
            "    `px_employee`.`employ_end_date`,\n" +
            "    `px_employee`.`laodong_guanxi`,\n" +
            "    `px_employee`.`zhuanzheng_date`,\n" +
            "    `px_employee`.`bank_card`,\n" +
            "    `px_employee`.`bank`,\n" +
            "    `px_employee`.`create_date`,\n" +
            "    `px_employee`.`update_date`\n" +
            " FROM  `px_employee`  \n" +
            " where  institution_code = #{institution_code} and phone like CONCAT('%',#{phone},'%') ")
    List<Employee> queryEmployeeListByPhoneWithLike(@Param("institution_code") String institution_code, @Param("phone") String phone);





    @Insert("  INSERT INTO  `px_employee`\n" +
            "( \n" +
            "`name`,\n" +
            "`phone`,\n" +
            "`sfzCode`,\n" +
            "`institution_code`,\n" +
            "`xiaoqu_name`,\n" +
            "`gender`,\n" +
            "`birthday`,\n" +
            "`english_name`,\n" +
            "`email`,\n" +
            "`ji_guan`,\n" +
            "`nationality`,\n" +
            "`zhengzhi_mianmao`,\n" +
            "`is_married`,\n" +
            "`biye_yuanxiao`,\n" +
            "`zhuanye`,\n" +
            "`xueli`,\n" +
            "`peixun_jingli`,\n" +
            "`renshi_zhuangtai`,\n" +
            "`employ_start_date`,\n" +
            "`employ_end_date`,\n" +
            "`laodong_guanxi`,\n" +
            "`zhuanzheng_date`,\n" +
            "`bank_card`,\n" +
            "`bank`,\n" +
            "`create_date`,\n" +
            "`update_date`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{name},\n" +
            "#{phone},\n" +
            "#{sfzCode},\n" +
            "#{institution_code},\n" +
            "#{xiaoqu_name},\n" +
            "#{gender},\n" +
            "#{birthday},\n" +
            "#{english_name},\n" +
            "#{email},\n" +
            "#{ji_guan},\n" +
            "#{nationality},\n" +
            "#{zhengzhi_mianmao},\n" +
            "#{is_married},\n" +
            "#{biye_yuanxiao},\n" +
            "#{zhuanye},\n" +
            "#{xueli},\n" +
            "#{peixun_jingli},\n" +
            "#{renshi_zhuangtai},\n" +
            "#{employ_start_date},\n" +
            "#{employ_end_date},\n" +
            "#{laodong_guanxi},\n" +
            "#{zhuanzheng_date},\n" +
            "#{bank_card},\n" +
            "#{bank},\n" +
            "#{create_date},\n" +
            "#{update_date});\n"
    )
    public int insertEmployee(Employee employee);


    @Update("  UPDATE  `px_employee`\n" +
            "SET\n" +
            "`name` = #{name},\n" +
            "`phone` = #{phone},\n" +
            "`sfzCode` = #{sfzCode},\n" +
            "`institution_code` = #{institution_code},\n" +
            "`xiaoqu_name` = #{xiaoqu_name},\n" +
            "`gender` = #{gender},\n" +
            "`birthday` = #{birthday},\n" +
            "`english_name` = #{english_name},\n" +
            "`email` = #{email},\n" +
            "`ji_guan` = #{ji_guan},\n" +
            "`nationality` = #{nationality},\n" +
            "`zhengzhi_mianmao` = #{zhengzhi_mianmao},\n" +
            "`is_married` = #{is_married},\n" +
            "`biye_yuanxiao` = #{biye_yuanxiao},\n" +
            "`zhuanye` = #{zhuanye},\n" +
            "`xueli` = #{xueli},\n" +
            "`peixun_jingli` = #{peixun_jingli},\n" +
            "`renshi_zhuangtai` = #{renshi_zhuangtai},\n" +
            "`employ_start_date` = #{employ_start_date},\n" +
            "`employ_end_date` = #{employ_end_date},\n" +
            "`laodong_guanxi` = #{laodong_guanxi},\n" +
            "`zhuanzheng_date` = #{zhuanzheng_date},\n" +
            "`bank_card` = #{bank_card},\n" +
            "`bank` = #{bank},\n" +
            "`update_date` = #{update_date}\n" +
            " where  institution_code = #{institution_code}  and sfzCode = #{sfzCode} and name = #{name} ")
    public int updateEmployee(Employee employee);


    @Delete(" DELETE FROM  `px_employee`\n" +
            "WHERE  name=#{name} and institution_code=#{institution_code} \n " +
            "     and sfzCode = #{sfzCode}  ;\n "   )
    public int deleteEmployee(Employee employee);


}
