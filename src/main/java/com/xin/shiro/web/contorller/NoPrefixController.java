package com.xin.shiro.web.contorller;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author xuexin
 * @date 2018/2/23
 */
@Controller
public class NoPrefixController {

    private static Logger LOGGER = LoggerFactory.getLogger(NoPrefixController.class);

    @RequestMapping("/index")
    public String index(Model model, HttpServletRequest request) {
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model, HttpServletRequest request) {
        if (request.getParameter("username") != null && request.getParameter("password") != null) {
            model.addAttribute("error", "用户名或密码错误");
        }
        LOGGER.debug("用户名或密码错误");
        LOGGER.info("用户名或密码错误------");
        return "login";
    }

    @RequestMapping("/register")
    public String register(Model model, HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal() == null) {
            return "register";
        }
        return "index";
    }

    @ResponseBody
    @RequestMapping("/{path}")
    public JSONObject echo(@PathVariable("path") String path,
                           HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        JSONObject object = new JSONObject();
        object.put("path", path);
        object.put("resultMessage", "success");
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            object.put(entry.getKey(), entry.getValue());
        }
        return object;
    }


}
