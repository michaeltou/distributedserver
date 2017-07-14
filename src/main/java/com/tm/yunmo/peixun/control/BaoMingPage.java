package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.model.BaoMing;
import com.tm.yunmo.peixun.service.BaoMingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Huangqijun on 2017/6/28.
 */
@Controller
public class BaoMingPage {

    @Autowired
    BaoMingService baomingService;
 

    @RequestMapping("/xiaobao/queryBaoMingByInstitution")
    public String queryBaoMingByInstitution(HttpServletRequest request, Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<BaoMing> baomingList = baomingService.queryBaoMingListByInstitution(institution_code);
        model.addAttribute("baoMingList",baomingList);
        return "xiaobao/baoMingList";
    }


    @RequestMapping("/xiaobao/createBaoMing")
    public String createClassrom(HttpServletRequest request,Model model){
        return "xiaobao/createBaoMing";
    }



    @RequestMapping("/xiaobao/updateBaoMing")
    public String updateBaoMing( BaoMing baoming,HttpServletRequest request,Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        int id =  baoming.getId();
        BaoMing baomingResult = baomingService.queryBaoMingByInstitutionAndId( institution_code,id);
        model.addAttribute("baoMing",baomingResult);
        return "xiaobao/updateBaoMing";
    }






}
