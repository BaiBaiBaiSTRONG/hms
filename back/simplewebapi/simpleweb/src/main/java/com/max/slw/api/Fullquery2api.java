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

@WebServlet(name = "Fullquery2api",urlPatterns = "/Fullquery2api")
public class Fullquery2api extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String tabletype = req.getParameter("tabletype");
        String querytype1 = req.getParameter("querytype1");
        String querytype2 = req.getParameter("querytype2");
        String querycontent1 = req.getParameter("querycontent1");
        String querycontent2 = req.getParameter("querycontent2");
        System.out.println(tabletype);
        List<Entity> list = null;
        System.out.println(querycontent2);
        FunctionsforProgramme way=new FunctionsforProgramme();

        try {

            list = way.Fullquery2(tabletype,querytype1,querytype2,querycontent1,querycontent2);
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
