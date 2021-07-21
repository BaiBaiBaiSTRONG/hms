package com.max.slw.api;

import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.max.slw.dao.FunctionsforProgramme;
import com.max.slw.dao.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PageBeanapi",urlPatterns = "/PageBeanapi")
public class PageBeanapi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String pageNum1 = req.getParameter("pageNum1");
        String pageSize1 = req.getParameter("pageSize1");
        System.out.println(pageNum1);
        System.out.println(pageSize1);
        List<Entity> list1 = null;
        FunctionsforProgramme way=new FunctionsforProgramme();
        int pageNum=Integer.parseInt(pageNum1);
        int pageSize=Integer.parseInt(pageSize1);
        System.out.println(pageNum);
        System.out.println(pageSize);
        PageBean<Entity> pagebean = new PageBean<Entity>();
        pagebean=pagebean.findalluserwithpage(pageNum,pageSize);
            list1 = pagebean.getList();

        System.out.println(list1);
        String json = JSONUtil.toJsonStr(list1);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();
    }
}
