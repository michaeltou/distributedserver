package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.model.BanJi;
import com.tm.yunmo.peixun.model.KeCheng;
import com.tm.yunmo.peixun.model.School;
import com.tm.yunmo.peixun.service.BanJiService;
import com.tm.yunmo.peixun.service.KeChengService;
import com.tm.yunmo.peixun.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by daoying on 2017/6/28.
 */
@Controller
public class BanJiPage {

    @Autowired
    BanJiService banJiService;
    @Autowired
    private SchoolService schoolService;

    @Autowired
    private KeChengService keChengService;

    @RequestMapping("/xiaobao/queryBanJiByInstitution")
    public String queryBanJiByInstitution(HttpServletRequest request, Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<BanJi> banJiList = banJiService.queryBanJiListByInstitution(institution_code);
        model.addAttribute("banJiList",banJiList);
        return "xiaobao/banJiList";
    }


    @RequestMapping("/xiaobao/createBanJi")
    public String createBanJi(HttpServletRequest request,Model model){

        String institution_code = (String) request.getSession().getAttribute("institution_code");

        List<School> schoolList =schoolService.querySchoolListByInstitution(institution_code);

        model.addAttribute("schoolList",schoolList);


        List<KeCheng> keChengList =  keChengService.queryKeChengListByInstitution(institution_code);
        model.addAttribute("keChengList",keChengList);

        return "xiaobao/createBanJi";
    }



    @RequestMapping("/xiaobao/updateBanJi")
    public String updateBanJi( BanJi banJi,HttpServletRequest request,Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        String banji_name =  banJi.getBanji_name();
        BanJi banJiResult = banJiService.queryBanJiByName( banji_name,institution_code);
        model.addAttribute("banJi",banJiResult);

        List<School> schoolList =schoolService.querySchoolListByInstitution(institution_code);
        model.addAttribute("schoolList",schoolList);

        List<KeCheng> keChengList =  keChengService.queryKeChengListByInstitution(institution_code);
        model.addAttribute("keChengList",keChengList);

        return "xiaobao/updateBanJi";
    }






}
