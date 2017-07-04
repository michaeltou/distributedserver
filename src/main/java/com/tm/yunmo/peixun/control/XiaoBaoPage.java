package com.tm.yunmo.peixun.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by daoying on 2017/7/4.
 */
@Controller
public class XiaoBaoPage {
        @GetMapping("/xiaobao")
        public String index( Model model) {
            return "xiaobao/index";
        }

    }
