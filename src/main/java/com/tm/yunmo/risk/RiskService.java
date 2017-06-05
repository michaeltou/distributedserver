package com.tm.yunmo.risk;

import com.tm.yunmo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by daoying on 2017/3/15.
 */

@Controller
public class RiskService {

    User user = new User();

    @Autowired
    private RiskDAO riskDAO;
    //入口
    @RequestMapping(value = "/risk")
    public String home(Model model) {
       model.addAttribute("user",user);
        return "risk/riskInput";
    }

 //提交表单后进行数据读取，并将数据传出
    @RequestMapping(value = "/checkRisk",method = RequestMethod.POST)
    public String checkRisk(User user, ModelMap model) {

        if (user.getId() != null && user.getId() != 0){
            user =   riskDAO.findUserById(user.getId());
        }else if ( !user.getMobilePhone().isEmpty()){
            user =   riskDAO.findUserByMobilePhone(user.getMobilePhone());
        }else if( !user.getIdentifyId().isEmpty()){
            user =  riskDAO.findUserByIdentifyId(user.getIdentifyId());
        }

        if (user == null){
            user = new User();

            model.addAttribute("riskScore", "98");

            model.addAttribute("riskDetail", "该用户有2笔贷款，平安银行、浦发银行；该用户有车辆一辆，车型BMW 7系；房子:湘江壹号");


        }
        model.addAttribute("riskScore", "98");

        model.addAttribute("riskDetail", "该用户有2笔贷款，平安银行、浦发银行；该用户有车辆一辆，车型BMW 7系；房子:湘江壹号");

        model.addAttribute("user", user);



        return "risk/riskResult";
    }
}
