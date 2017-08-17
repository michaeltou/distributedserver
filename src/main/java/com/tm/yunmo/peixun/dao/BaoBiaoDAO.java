package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.BaoBiao1;
import com.tm.yunmo.peixun.model.ShouZhiDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * Created by lenovo on 2017/8/11.
 */
@Mapper
public interface BaoBiaoDAO {

    @SelectProvider(type = SqlProvider.class,method = "queryBaoBiao1ListByInstitution")
    List<BaoBiao1> queryBaoBiao1ListByInstitution(String institution_code,String schoolList,String startDate,String endDate);


    @SelectProvider(type = SqlProvider.class,method = "queryShouZhiDetailListByInstitutionForYear")
    List<ShouZhiDetail> queryShouZhiDetailListByInstitutionForYear(String institution_code,String schoolList,String startDate,String endDate);
}
