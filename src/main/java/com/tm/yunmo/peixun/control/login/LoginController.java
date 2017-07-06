package com.tm.yunmo.peixun.control.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by daoying on 2017/7/4.
 */
@Controller
public class LoginController {


    @GetMapping("/")
    public String index( Model model) {
        return "jianli/jianli";
    }


  /**  @GetMapping("/login")
    public String login() {
        return "login/login";
    }

    @PostMapping("/loginPost")
    public @ResponseBody
    Map<String, Object> loginPost(String account, String password, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        if (!"123456".equals(password)) {
            map.put("success", false);
            map.put("message", "密码错误");
            return map;
        }

        // 设置session
        session.setAttribute(LoginConst.SESSION_KEY, account);

        map.put("success", true);
        map.put("message", "登录成功");
        return map;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(LoginConst.SESSION_KEY);
        return "login/login";
    }

    */
}
