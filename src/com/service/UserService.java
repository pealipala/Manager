package com.service;

import com.pojo.User;

import java.util.List;

public interface UserService {
    //检验用户登录信息
    User checkLoginService(String uname, String pwd);
    //修改用户密码
    int changeUserPwdService(String newPwd,int id);
    //获取所有用户信息
    List<User> showUserInfoService();
    //用户注册
    int registerUser(User user);
    //查询指定用户信息
    User userSearchService(String uname);
}
