package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.BaoBiao1;
import com.tm.yunmo.peixun.model.ShouZhiDetail;
import com.tm.yunmo.peixun.service.BaoBiaoService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Huangqijun on 2017/8/15.
 */
@RestController
public class BaoBiaoApi {

    @Autowired
    private BaoBiaoService baoBiaoService;

    @RequestMapping("/queryBaoBiao1ListByInstitution")
    public ResultModel queryBaoBiao1ListByInstitution(HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        String schoolList = (String) request.getParameter("schoolList");
        String startDate = (String) request.getParameter("startDate");
        String endDate = (String) request.getParameter("endDate");
        if(!(startDate == null || "".equals(startDate))){
            startDate += " 00:00:00";
        }
        if(!(endDate == null || "".equals(endDate))){
            endDate += " 23:59:59";
        }
        List<String> schools = Arrays.asList(schoolList.split(","));
        List<BaoBiao1> baoBiao1List = baoBiaoService.queryBaoBiao1ListByInstitution(institution_code,schoolList,startDate,endDate);
        for (BaoBiao1 baoBiao:baoBiao1List) {
            if(schools.contains(baoBiao.getHandingSchool())){
                schoolList = schoolList.replace(baoBiao.getHandingSchool(),"");
            }
        }

        schools = Arrays.asList(schoolList.split(","));
        for (String school : schools){
            if(!"".equals(school)){
                BaoBiao1 baoBiao1 = new BaoBiao1();
                baoBiao1.setHandingSchool(school);
                baoBiao1.setLirun(0.0);
                baoBiao1.setZhichu(0.0);
                baoBiao1.setShouru(0.0);
                baoBiao1List.add(baoBiao1);
            }
        }

        resultModel.setData(baoBiao1List);
        return resultModel;
    }

    @RequestMapping("/queryShouZhiDetailListByInstitutionForYear")
    public ResultModel queryShouZhiDetailListByInstitutionForYear(HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        String schoolList = (String) request.getParameter("schoolList");
        String reportYear = (String) request.getParameter("reportYear");
        String startDate = reportYear +"-01-01 00:00:00";
        String endDate = reportYear +"-12-31 23:59:59";
        List<BaoBiao1> baoBiao1List = new ArrayList<BaoBiao1>();
        for(int i = 1;i<=12;i++){
            String month = reportYear +"年"+ i+"月";
            BaoBiao1 baoBiao = new BaoBiao1();
            baoBiao.setMonth(month);
            baoBiao.setShouru(0.0);
            baoBiao.setZhichu(0.0);
            baoBiao.setLirun(0.0);
            baoBiao1List.add(baoBiao);
        }
        List<ShouZhiDetail> shouZhiDetailList = baoBiaoService.queryShouZhiDetailListByInstitutionForYear(institution_code,schoolList,startDate,endDate);
        for (ShouZhiDetail detail : shouZhiDetailList){
            int month = detail.getHandingDate().getMonth();
            if(detail.getType() == 1){
                baoBiao1List.get(month).setShouru(baoBiao1List.get(month).getShouru() + detail.getAmount());
            }
            else {
                baoBiao1List.get(month).setZhichu(baoBiao1List.get(month).getZhichu() + detail.getAmount());
            }
        }
        for(int i = 0;i< 12;i++){
            baoBiao1List.get(i).setLirun(baoBiao1List.get(i).getShouru() -baoBiao1List.get(i).getZhichu() );
        }

        resultModel.setData(baoBiao1List);
        return resultModel;
    }
}
