package com.tm.yunmo.marketing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daoying on 2017/3/20.
 */

@Controller
public class MarketingService {

    UserProductScore userProductScore = new UserProductScore();

    @Autowired
    private MarketingDAO marketingDAO;
    //入口
    @RequestMapping(value = "/marketing")
    public String home(Model model) {
        model.addAttribute("userProductScore",userProductScore);
        return "marketing/marketingInput";
    }

    //提交表单后进行数据读取，并将数据传出
    @RequestMapping(value = "/queryMarketing",method = RequestMethod.POST)
    public String checkRisk(UserProductScore userProductScore, ModelMap model) {

        List<UserProductScore> userProductScoreList = new ArrayList<UserProductScore>();
        if ( userProductScore.getUserId() != null && userProductScore.getUserId() != 0){
            userProductScoreList =   marketingDAO.findMarketingByUserId(userProductScore.getUserId());
        }else if ( !userProductScore.getMobilePhone().isEmpty()){
            userProductScoreList =   marketingDAO.findMarketingByMobilePhone(userProductScore.getMobilePhone());
        }else if( !userProductScore.getUserName().isEmpty()){
            userProductScoreList =  marketingDAO.findMarketingByUserName(userProductScore.getUserName());
        }

        if (userProductScoreList == null || userProductScoreList.isEmpty()){
            userProductScoreList = new ArrayList<>();
        }
        model.addAttribute("userProductScoreList", userProductScoreList);



        return "marketing/marketingResult";
    }
}
