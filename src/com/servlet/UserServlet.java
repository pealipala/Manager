package com.servlet;

import com.google.gson.Gson;
import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "user",urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    //声明日志对象
    org.apache.log4j.Logger logger= org.apache.log4j.Logger.getLogger(UserServlet.class);
    //创建service层对象
    UserService userService=null;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求信息
            //获取操作符
        String oper=req.getParameter("oper");
        if ("login".equals(oper)){
            //调用登录处理功能
            checkUserLogin(req,resp);
        }else if("reg".equals(oper)){
            //调用注册处理功能
            registerUser(req,resp);
        }else if ("pwd".equals(oper)){
            //调用修改密码功能
            userChangePwd(req,resp);
        }else if ("show".equals(oper)){
            //调用显示所有用户功能
            showUserInfo(req,resp);
        } else if ("out".equals(oper)){
            //调用退出功能
            userOut(req,resp);
        }else if("search".equals(oper)){
            userSearch(req,resp);
        } else if ("relogin".equals(oper)){
            userReLogin(req,resp);
        }else{
            logger.debug("没有找到对应的操作符"+oper);
        }
    }

    //登录失效重新登录
    private void userReLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession httpSession=req.getSession();
        httpSession.setAttribute("flag",3);
        //重定向
        resp.sendRedirect("login.jsp");
        return;
    }

    //搜索用户信息
    private void userSearch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取请求信息
        String uname=req.getParameter("uname");
        //处理请求信息
            //获取业务层对象
            userService=new UserServiceImpl();
            //处理业务
            User user=userService.userSearchService(uname);
        //响应处理结果
        resp.getWriter().write(new Gson().toJson(user));


    }

    //注册用户
    private void registerUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取请求信息
        String uname=req.getParameter("uname");
        String pwd=req.getParameter("pwd");
        String sex=req.getParameter("sex");
        int age= Integer.parseInt(req.getParameter("age"));
        String birth=req.getParameter("birth");
        //日期拼接
        String[] bs=null;
        if (birth!=" "){
            bs=birth.split("/");
            birth=bs[2]+"-"+bs[0]+"-"+bs[1];
        }
        //处理请求信息
             //调用业务层对象
        User user=new User(0,uname,pwd,sex,age,birth);
        userService=new UserServiceImpl();
        int index=userService.registerUser(user);
        //响应处理结果
        if (index>0){
            HttpSession httpSession=req.getSession();
            httpSession.setAttribute("flag",2);
            resp.sendRedirect("/login.jsp");
            return;
        }
    }

    //显示所有用户数据
    private void showUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用service层
        userService=new UserServiceImpl();
        List<User> lu=userService.showUserInfoService();
        if (lu!=null){
            //将查询到的数据存储到request对象
            req.setAttribute("lu",lu);
            //请求转发
            req.getRequestDispatcher("/main/allUserInfo.jsp").forward(req,resp);
        }
    }

    //处理用户修改密码
    private void userChangePwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取数据
        String newPwd=req.getParameter("newPwd");
            //从session中获取用户信息
        User user= (User) req.getSession().getAttribute("user");
        int id=user.getId();
            //处理请求
                //调用Service对象
        userService=new UserServiceImpl();
        int index=userService.changeUserPwdService(newPwd,id);
        if (index>0) {
            //获取session对象
            HttpSession httpSession=req.getSession();
            httpSession.setAttribute("flag",1);
            //重定向
            resp.sendRedirect("/login.jsp");
            return;
        }else {

        }
    }

    //处理用户退出
    private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取session对象
        HttpSession hs=req.getSession();
        //强制销毁session
        hs.invalidate();
        //重定向
        resp.sendRedirect("/login.jsp");
        return;
    }

    //处理用户登录
    private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        //获取请求参数
        String uname=req.getParameter("uname");
        String pwd=req.getParameter("pwd");
        //处理请求信息
        //调用业务层对象
            //创建用户对象
        userService=new UserServiceImpl();
        User user=userService.checkLoginService(uname,pwd);
        //响应处理结果
        if(user!=null){
//            String id=user.getId()+"";
//            //创建Cookie对象
//            Cookie cookie=new Cookie("id",id);
//            //设置cookie路径
//            cookie.setPath("main/main.jsp");
//            //设置cookie有效期
//            cookie.setMaxAge(3*24*3600);
//            //响应cookie给信息给客户端
//            resp.addCookie(cookie);
            //获取session对象
            ServletContext sc=this.getServletContext();
            if (sc.getAttribute("nums")!=null){
                int nums= (int) sc.getAttribute("nums");
                sc.setAttribute("nums",++nums);
            }else{
                sc.setAttribute("nums",1);
            }
            HttpSession httpSession = req.getSession();
            //将用户数据存储在session中
            httpSession.setAttribute("user",user);
            //重定向
            resp.sendRedirect("main/main.jsp");
            return;
        }else{
            //请求转发
            req.setAttribute("flag",0);
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }
    }
}
