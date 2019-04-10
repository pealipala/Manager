package com.dao.impl;

import com.dao.UserDao;
import com.pojo.User;
import com.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    //获取数据库连接对象
    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    //获取用户对象
    User user=null;

    //检查用户登录
    @Override
    public User checkLoginDao(String uname, String pwd) {
        try {
            //数据库连接
            conn= JDBCUtil.getConnection();
            //创建sql命令
            String sql="SELECT  * from t_user WHERE uname=?  AND  pwd=?";
            //创建sql命令对象
            ps=conn.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1,uname);
            ps.setString(2,pwd);
            //执行sql命令
            rs=ps.executeQuery();
            //遍历执行结果
            while(rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setUname(rs.getString("uname"));
                user.setPwd(rs.getString("pwd"));
                user.setSex(rs.getString("sex"));
                user.setAge(rs.getInt("age"));
                user.setBirth(rs.getString("birth"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JDBCUtil.release(rs,conn,ps);
        }
        return user;
    }

    //修改用户密码
    @Override
    public int changeUserPwdDao(String newPwd, int id) {
        //创建变量
        int index=-1;
        try {
            //数据库连接
            conn=JDBCUtil.getConnection();
            //创建sql命令
            String sql="update  t_user SET pwd=? WHERE id=?";
            //创建sql命令对象
            ps=conn.prepareStatement(sql);
            //占位符赋值
            ps.setString(1,newPwd);
            ps.setInt(2,id);
            //执行
            index=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭结果
            JDBCUtil.release(conn,ps);
        }
        //返回结果
        return index;
    }

    //查询所有用户数据
    @Override
    public List<User> showUserInfoDao() {
        //声明变量
        List<User> lu=null;
        try {
            //数据库连接
            conn= JDBCUtil.getConnection();
            //创建sql命令
            String sql="SELECT  * from t_user";
            //创建sql命令对象
            ps=conn.prepareStatement(sql);
            //执行sql命令
            rs=ps.executeQuery();
            //给集合赋值
            lu=new ArrayList<User>();
            //遍历执行结果
            while(rs.next()){
                //给变量赋值
                user=new User();
                user.setId(rs.getInt("id"));
                user.setUname(rs.getString("uname"));
                user.setPwd(rs.getString("pwd"));
                user.setSex(rs.getString("sex"));
                user.setAge(rs.getInt("age"));
                user.setBirth(rs.getString("birth"));
                //将对象存储到集合中
                lu.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JDBCUtil.release(rs,conn,ps);
        }
        return lu;
    }

    @Override
    public int registerUser(User user) {
        int index=-1;
        try {
            //数据库连接
            conn=JDBCUtil.getConnection();
            //创建sql命令
            String sql="INSERT  INTO  t_user VALUES (DEFAULT ,?,?,?,?,?)";
            //创建sql命令对象
            ps=conn.prepareStatement(sql);
            //占位符赋值
            ps.setString(1,user.getUname());
            ps.setString(2,user.getPwd());
            ps.setString(3,user.getSex());
            ps.setInt(4,user.getAge());
            ps.setString(5,user.getBirth());
            //执行
            index=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭结果
            JDBCUtil.release(conn,ps);
        }
        //返回结果
        return index;
    }

    @Override
    public User userSearchDao(String uname) {
        try {
            //数据库连接
            conn= JDBCUtil.getConnection();
            //创建sql命令
            String sql="SELECT  * from t_user WHERE uname=?";
            //创建sql命令对象
            ps=conn.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1,uname);
            //执行sql命令
            rs=ps.executeQuery();
            //遍历执行结果
            while(rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setUname(rs.getString("uname"));
                user.setPwd(rs.getString("pwd"));
                user.setSex(rs.getString("sex"));
                user.setAge(rs.getInt("age"));
                user.setBirth(rs.getString("birth"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JDBCUtil.release(rs,conn,ps);
        }
        return user;
    }
}
