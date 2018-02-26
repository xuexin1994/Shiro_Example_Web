package com.xin.shiro.web.contorller;

import com.alibaba.fastjson.JSONObject;
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
    @RequestMapping("/index")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model, HttpServletRequest request) {
        return "login";
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
