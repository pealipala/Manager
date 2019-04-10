package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    static String driverClass=null;
    static String url=null;
    static String user=null;
    static String psd=null;

//静态代码块，获取配置文件对象
    static {
        try {
            //创建一个属性配置对象
            Properties properties=new Properties();
            // InputStream is=new FileInputStream("src/jdbc.properties");
            //使用类加载器读取src下面的资源文件
            InputStream is=JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(is);
            //读取属性
            driverClass= properties.getProperty("driverClass");
            url= properties.getProperty("url");
            user= properties.getProperty("user");
            psd= properties.getProperty("psd");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection  getConnection(){
        Connection conn=null;
        try{
            //1:注册驱动 DriverManager.registerDriver(new com.mysql.jdbc.Driver());内部Driver已经注册了一次 不需要再写，防止二次注册
            //JDK4.0以后 下面这行代码可以不用写
            Class.forName(driverClass);
            //2:建立连接：1.协议+数据库 2.用户名 3.密码
            conn=DriverManager.getConnection(url,user,psd);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    private static void closeRs(ResultSet rs) {
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                rs=null;
            }
        }
    }
    private static void closeConn(Connection conn){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                conn=null;

            }
        }
    }
    private static void closeSt(Statement st){
        if (st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                st=null;
            }
        }
    }
    private static void closePs(PreparedStatement ps) {
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ps=null;
            }
        }
    }
    //释放资源
    public  static void release(ResultSet rs,Connection conn,Statement st){
        closeRs(rs);
        closeConn(conn);
        closeSt(st);
    }
    public  static void release(Connection conn,Statement st){
        closeConn(conn);
        closeSt(st);
    }
    public  static void release(ResultSet rs,Connection conn,PreparedStatement ps){
        closeRs(rs);
        closeConn(conn);
        closePs(ps);
    }
    public  static void release(Connection conn,PreparedStatement ps){
        closeConn(conn);
        closePs(ps);
    }

}
