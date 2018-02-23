package com.xin.shiro.web.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xuexin
 * @date 2018/2/23
 */
@Controller
public class UserController {
    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("message","登陆成功");
        return "forward:index.jsp";
    }

    @RequestMapping("/toLogin")
    public String toLogin(Model model){
        model.addAttribute("message","登陆成功");
        return "login";
    }


}
