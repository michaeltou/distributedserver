package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.control.login.LoginConst;
import com.tm.yunmo.peixun.model.BaoMing;
import com.tm.yunmo.peixun.model.UserPictures;
import com.tm.yunmo.peixun.service.BaoMingService;
import com.tm.yunmo.peixun.service.ClassRecordDetailService;
import com.tm.yunmo.peixun.service.UserPicturesService;
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
public class ZuoPingShangChuanPage {

    @Autowired
    BaoMingService baoMingService;

    @Autowired
    ClassRecordDetailService classRecordDetailService;


    @Autowired
    UserPicturesService userPicturesService;


    @RequestMapping("/xiaobao/zuoPingShangChuanPage")
    public String zuopingshangchuan(HttpServletRequest request, Model model ){
        String institution_code = (String) request.getSession().getAttribute("institution_code");

        String sfzCode = (String) request.getSession().getAttribute("sfzCode");


        List<BaoMing> baoMingList = baoMingService.queryBaoMingListBySFZCode(institution_code,sfzCode);

        model.addAttribute("baoMingList",baoMingList);

        return "xiaobao/zuoPingShangChuan";
    }



    @RequestMapping("/xiaobao/myZuoPingPage")
    public String myZuoPingPage(HttpServletRequest request, Model model ){
        String sfzCode = (String) request.getSession().getAttribute("sfzCode");
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<BaoMing> baoMingList = baoMingService.queryBaoMingListBySFZCode(institution_code,sfzCode);
        model.addAttribute("baoMingList",baoMingList);

        List<UserPictures> userPicturesList =  userPicturesService.queryUserPicturesByUserName(institution_code,sfzCode);

        for (UserPictures userPictures:userPicturesList  ) {
            String fullUrl = LoginConst.imageHost + userPictures.getPicture_name();
            userPictures.setFullUrl(fullUrl);
        }
        model.addAttribute("userPicturesList",userPicturesList);
        return "xiaobao/myZuoPingPage";
    }






}
