package com.listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.*;

public class Listener implements HttpSessionListener,ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //获取application对象
        ServletContext sc=servletContextEvent.getServletContext();
        //添加在线人数
        sc.setAttribute("count",0);

        String Path=sc.getRealPath("/WEB-INF/nums/nums.txt");
        BufferedReader br=null;
        FileReader fr=null;
        try {
            fr=new FileReader(Path);
            br=new BufferedReader(fr);
            int nums= Integer.parseInt(br.readLine());
            sc.setAttribute("nums",nums);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext sc=servletContextEvent.getServletContext();
        String Path=sc.getRealPath("/WEB-INF/nums/nums.txt");
        int nums= (int) sc.getAttribute("nums");
        BufferedWriter bw=null;
        FileWriter fw=null;
        try {
            fw=new FileWriter(Path);
            bw=new BufferedWriter(fw);
            bw.write(nums+"");
            bw.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        //获取application对象
        ServletContext sc=httpSessionEvent.getSession().getServletContext();
        //获取在线人数
        int count= (int) sc.getAttribute("count");
        //在线人数自增
        System.out.println("test");
        sc.setAttribute("count",++count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        //获取application对象
        ServletContext sc=httpSessionEvent.getSession().getServletContext();
        //获取在线人数
        int count= (int) sc.getAttribute("count");
        //在线人数自减
        sc.setAttribute("count",--count);
    }
}
