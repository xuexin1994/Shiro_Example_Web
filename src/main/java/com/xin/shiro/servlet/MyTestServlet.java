package com.xin.shiro.servlet;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "testServlet", urlPatterns = "/test")
public class MyTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = SecurityUtils.getSubject().getSession();
        System.out.println(session.getTimeout());
        System.out.println(session.getStartTimestamp());
        System.out.println(session.getLastAccessTime());
        session.touch();
        session.stop();
        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
