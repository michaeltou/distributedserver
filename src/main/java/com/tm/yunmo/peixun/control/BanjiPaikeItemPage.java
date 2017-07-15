package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.model.BanjiPaikeItem;
import com.tm.yunmo.peixun.service.BanjiPaikeItemService;
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
public class BanjiPaikeItemPage {

    @Autowired
    BanjiPaikeItemService banjiPaikeItemService;
 

    @RequestMapping("/xiaobao/queryBanjiPaikeItemByInstitution")
    public String queryBanjiPaikeItemByInstitution(HttpServletRequest request, Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<BanjiPaikeItem> banjiPaikeItemList = banjiPaikeItemService.queryBanjiPaikeItemListByInstitution(institution_code);
        model.addAttribute("banjiPaikeItemList",banjiPaikeItemList);
        return "xiaobao/banjiPaikeItemList";
    }


    @RequestMapping("/xiaobao/createBanjiPaikeItem")
    public String createClassrom(HttpServletRequest request,Model model){
        return "xiaobao/createBanjiPaikeItem";
    }



    @RequestMapping("/xiaobao/updateBanjiPaikeItem")
    public String updateBanjiPaikeItem( BanjiPaikeItem banjiPaikeItem,HttpServletRequest request,Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        int id = banjiPaikeItem.getId();
        BanjiPaikeItem banjiPaikeItemResult = banjiPaikeItemService.queryBanjiPaikeItemByInstitutionAndId( institution_code,id);
        model.addAttribute("banjiPaikeItem",banjiPaikeItemResult);
        return "xiaobao/updateBanjiPaikeItem";
    }






}
