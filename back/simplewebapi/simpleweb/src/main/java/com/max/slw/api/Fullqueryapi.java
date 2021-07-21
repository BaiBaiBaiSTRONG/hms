package com.max.slw.api;

import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.max.slw.dao.FunctionsforProgramme;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Fullquerynewapi",urlPatterns = "/Fullquerynewapi")
public class Fullqueryapi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String tabletype = req.getParameter("tabletype");
        String querytype = req.getParameter("querytype");
        String querycontent = req.getParameter("querycontent");
        System.out.println(tabletype);
        List<Entity> list = null;
        FunctionsforProgramme way=new FunctionsforProgramme();
        try {

            list = way.Fullquery(tabletype,querytype,querycontent);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(list);
        String json = JSONUtil.toJsonStr(list);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();
    }
}