package com.max.slw.api;

import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.max.slw.dao.DemoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserQueryById", urlPatterns = "/userquerybyid")
public class UserQueryById extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        DemoDao dao = new DemoDao();
        Entity entity = dao.queryById(id);

        String json = JSONUtil.toJsonStr(entity);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();
    }
}
