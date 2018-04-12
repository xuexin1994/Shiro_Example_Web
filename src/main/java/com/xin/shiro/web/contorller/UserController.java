package com.xin.shiro.web.contorller;

import com.xin.shiro.entity.User;
import com.xin.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xuexin
 * @date 2018/3/2
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/creat")
    public String login(Model model, HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (!StringUtils.hasText(username)){
            model.addAttribute("error","用户名不能为空");
            return "register";
        }
        if (!StringUtils.hasText(password)){
            model.addAttribute("error","用户名不能为空");
            return "register";
        }
        User user = userService.findByUsername(username);
        if (user!=null) {
            model.addAttribute("error", "用户已存在");
            return "register";
        }
        User createUser = new User(username,password);
        userService.createUser(createUser);
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        SecurityUtils.getSubject().login(token);
        return "index";
    }
}
