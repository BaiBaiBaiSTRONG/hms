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

@WebServlet(name = "Datequeryapi",urlPatterns = "/Datequeryapi")
public class Datequeryapi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String date1 = req.getParameter("date1");
        String date2 = req.getParameter("date2");

        System.out.println(date1);
        List<Entity> list = null;
        FunctionsforProgramme way=new FunctionsforProgramme();

        list = way.billsbydate(date1,date2);
        System.out.println(list);
        String json = JSONUtil.toJsonStr(list);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();
    }
}
