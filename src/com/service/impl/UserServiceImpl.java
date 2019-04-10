package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.pojo.User;
import com.service.UserService;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.List;
import java.util.logging.Logger;

public class UserServiceImpl implements UserService {
    //声明日志对象
    org.apache.log4j.Logger logger= org.apache.log4j.Logger.getLogger(UserServiceImpl.class);
    //创建dao层过度向
    UserDao userDao=new UserDaoImpl();

    //检验用户登录信息
    @Override
    public User checkLoginService(String uname, String pwd) {
        //打印日志
        logger.debug(uname+":发起登录请求");
        User u=userDao.checkLoginDao(uname,pwd);
        //判断
        if (u!=null){
            logger.debug(uname+":登录成功");
        }
        else {
            logger.debug(uname+":登录失败");
        }
        return u;
    }

    //修改用户密码
    @Override
    public int changeUserPwdService(String newPwd, int id) {
        //打印日志
        logger.debug(id+":发起密码修改");
        int index=userDao.changeUserPwdDao(newPwd,id);
        //判断
        if (index>0){
            logger.debug(id+":密码修改成功");
        }
        else {
            logger.debug(id+":密码修改失败");
        }
        return index;
    }

    @Override
    public List<User> showUserInfoService() {

        List<User> lu=userDao.showUserInfoDao();
        logger.debug("显示所用用户信息:"+lu);
        return lu;
    }

    @Override
    public int registerUser(User user) {
        logger.debug("注册用户:");
        int index=userDao.registerUser(user);
        if (index>0){
            logger.debug("用户注册成功");
        }else {
            logger.debug("用户注册失败");
        }
        return index;
    }

    @Override
    public User userSearchService(String uname) {
        return userDao.userSearchDao(uname);
    }
}
