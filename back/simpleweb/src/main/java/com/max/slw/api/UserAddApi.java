package com.max.slw.api;

import cn.hutool.json.JSONUtil;
import com.max.slw.dao.DemoDao;
import com.max.slw.dao.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserAddApi", urlPatterns = "/user/add")
public class UserAddApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }

    private void doHttp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 1.ACCEPT THE INPUT HTTP PARAMETER "name"
        String name = req.getParameter("name");
        System.out.println("Input name:" + name);
        // 1.5 EXECUTE THE INNER LOGIC
        var dao = new DemoDao();
        var user = new User();
        user.setName(name);

        int result = dao.insert(user);
        boolean blres = (result != 0);

        // 1.6 Generate the needed json character
        var bean = new DemoBean();
        bean.setRes(blres);
        String json = JSONUtil.toJsonStr(bean);

        // 2.Output bool value , represent success or not
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();
    }
}
