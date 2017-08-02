package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.BanjiPaikeItemDAO;
import com.tm.yunmo.peixun.model.BanjiPaikeItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 *  班级排课日程表service类.
 */
@Component
public class BanjiPaikeItemService {

    @Autowired
    private BanjiPaikeItemDAO banjiPaikeItemDAO;


    public List<BanjiPaikeItem> queryBanjiPaikeItemListByInstitution(String institution_code ){
        List<BanjiPaikeItem> banjiPaikeItemList = banjiPaikeItemDAO.queryBanjiPaikeItemListByInstitution( institution_code);
        return banjiPaikeItemList;
    }

    public List<BanjiPaikeItem> queryBanjiPaikeItemListByInstitutionAndSchoolname(String institution_code,String xiaoqu_name ){
        List<BanjiPaikeItem> banjiPaikeItemList = banjiPaikeItemDAO.queryBanjiPaikeItemListByInstitutionAndSchoolname( institution_code,xiaoqu_name);
        return banjiPaikeItemList;
    }

    public List<BanjiPaikeItem> queryBanjiPaikeItemListByInstitutionAndXiaoquNameAndBanjiName(String institution_code,  String xiaoqu_name,  String banji_name){
        List<BanjiPaikeItem> banjiPaikeItemList = banjiPaikeItemDAO.queryBanjiPaikeItemListByInstitutionAndXiaoquNameAndBanjiName( institution_code,xiaoqu_name,banji_name);
        return banjiPaikeItemList;
    }


    public BanjiPaikeItem queryBanjiPaikeItemByInstitutionAndId(String institution_code,  int id){
        BanjiPaikeItem banjiPaikeItem = banjiPaikeItemDAO.queryBanjiPaikeItemByInstitutionAndId( institution_code,id);
        return banjiPaikeItem;
    }

    public BanjiPaikeItem queryBanjiPaikeItemByInstitutionAndBanjiNameAndId(String institution_code,  String xiaoqu_name,  String banji_name,int id){
        BanjiPaikeItem banjiPaikeItem = banjiPaikeItemDAO.queryBanjiPaikeItemByInstitutionAndBanjiNameAndId( institution_code,xiaoqu_name,banji_name,id);
        return banjiPaikeItem;
    }

    public List<BanjiPaikeItem>  queryBanjiPaikeItemByStartAndEndAndClassName(String institution_code, String banji_name, Date start, Date end,int id){
        List<BanjiPaikeItem>  banjiPaikeItemList = banjiPaikeItemDAO.queryBanjiPaikeItemByStartAndEndAndClassName( institution_code,banji_name,start,end,id);
        return banjiPaikeItemList;
    }

    public List<BanjiPaikeItem>  queryBanjiPaikeItemByStartAndEndAndTeacherCode(String institution_code, String teacherCode, Date start, Date end,int id){
        List<BanjiPaikeItem>  banjiPaikeItemList = banjiPaikeItemDAO.queryBanjiPaikeItemByStartAndEndAndTeacherCode( institution_code,teacherCode,start,end,id);
        return banjiPaikeItemList;
    }

    public List<BanjiPaikeItem>  queryBanjiPaikeItemByStartAndEndAndAssistTeacherCode(String institution_code, String assistTeacherCode, Date start, Date end,int id){
        List<BanjiPaikeItem>  banjiPaikeItemList = banjiPaikeItemDAO.queryBanjiPaikeItemByStartAndEndAndAssistTeacherCode( institution_code,assistTeacherCode,start,end,id);
        return banjiPaikeItemList;
    }

    public List<BanjiPaikeItem>  queryBanjiPaikeItemByStartAndEndAndClassroomName(String institution_code, String classroomName, Date start, Date end,int id){
        List<BanjiPaikeItem>  banjiPaikeItemList = banjiPaikeItemDAO.queryBanjiPaikeItemByStartAndEndAndClassroomName( institution_code,classroomName,start,end,id);
        return banjiPaikeItemList;
    }

    public List<BanjiPaikeItem>  queryBanjiPaikeItemByFilter(String institution_code, String xiaoqu_name,String banji_name,String jiaoshi_sfzCode, String classroom_name){
        List<BanjiPaikeItem>  banjiPaikeItemList = banjiPaikeItemDAO.queryBanjiPaikeItemByFilter( institution_code,xiaoqu_name,banji_name,jiaoshi_sfzCode,classroom_name);
        return banjiPaikeItemList;
    }

    public List<BanjiPaikeItem> queryBanjiPaikeItemByUIData(String institution_code, String classroomName, String banji_name, String jiaoshi_sfzCode,String assist_teacher_sfzCode, Date start, Date end){
        List<BanjiPaikeItem>  banjiPaikeItemList = banjiPaikeItemDAO.queryBanjiPaikeItemByUIData( institution_code,classroomName,banji_name,jiaoshi_sfzCode,assist_teacher_sfzCode,start,end);
        return banjiPaikeItemList;
    }


    public int insertBanjiPaikeItem(BanjiPaikeItem banjiPaikeItem) {
        int result = banjiPaikeItemDAO.insertBanjiPaikeItem(banjiPaikeItem);
        return result;
    }


    public int updateBanjiPaikeItem(BanjiPaikeItem banjiPaikeItem) {
        int result = banjiPaikeItemDAO.updateBanjiPaikeItem(banjiPaikeItem);
        return result;
    }


    public int deleteBanjiPaikeItem(BanjiPaikeItem banjiPaikeItem) {
        int result = banjiPaikeItemDAO.deleteBanjiPaikeItem(banjiPaikeItem);
        return result;
    }

}
