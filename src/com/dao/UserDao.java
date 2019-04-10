package com.dao;

import com.pojo.User;

import java.util.List;

public interface UserDao {
    //检查用户登录
    User checkLoginDao(String uname,String pwd);
    //修改用户密码
    int changeUserPwdDao(String newPwd,int id);
    //获取所有用户信息
    List<User> showUserInfoDao();
    //用户注册
    int registerUser(User user);
    //指定用户信息查询
    User userSearchDao(String uname);

}
