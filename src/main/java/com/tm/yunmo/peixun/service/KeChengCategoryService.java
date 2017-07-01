package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.KeChengCategoryDAO;
import com.tm.yunmo.peixun.model.KeChengCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 */
@Component
public class KeChengCategoryService {

    @Autowired
    private KeChengCategoryDAO keChengCategoryDAO;




    public List<KeChengCategory>  queryKeChengCategoryByInstitution(String institution_code){
        List<KeChengCategory> keChengCategoryList = keChengCategoryDAO.queryKeChengCategoryByInstitution(institution_code);
        return keChengCategoryList;
    }

    /**
     *
     * @param id
     * @return
     */
    public KeChengCategory queryKeChengCategoryById(int id,String institution_code){
        KeChengCategory keChengCategory = keChengCategoryDAO.queryKeChengCategoryById(id,institution_code);
        return keChengCategory;
    }


    public KeChengCategory queryKeChengCategoryByName(String name,String institution_code){
        KeChengCategory keChengCategory = keChengCategoryDAO.queryKeChengCategoryByName(name,institution_code);
        return keChengCategory;
    }

    public List<KeChengCategory>  queryKeChengCategoryByNameWithLike(String name,String institution_code){
        List<KeChengCategory> keChengCategoryList = keChengCategoryDAO.queryKeChengCategoryByNameWithLike(name,institution_code);
        return keChengCategoryList;
    }


    public int insertKeChengCategory(KeChengCategory KeChengCategory){
        int result =  keChengCategoryDAO.insertKeChengCategory(KeChengCategory);
        return result;
    }



    public int updateChengCategory(KeChengCategory KeChengCategory){
       int result =  keChengCategoryDAO.updateChengCategory(KeChengCategory);
       return result;
    }

    public int deleteChengCategory(KeChengCategory KeChengCategory){
        int result =  keChengCategoryDAO.deleteChengCategory(KeChengCategory);
        return result;
    }



}
