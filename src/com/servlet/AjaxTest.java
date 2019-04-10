package com.servlet;

import com.google.gson.Gson;
import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AjaxTest",urlPatterns = "/ajax")
public class AjaxTest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求信息
        String uname=req.getParameter("uname");
        System.out.println("用户请求信息为:"+uname);
        //处理请求信息
        //获取业务层对象
        UserService userService = new UserServiceImpl();
        //处理业务
        User user=userService.userSearchService(uname);
        //响应处理结果
        resp.getWriter().write(new Gson().toJson(user));
    }


}
