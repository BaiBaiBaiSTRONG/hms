package com.max.slw.api;

import cn.hutool.json.JSONUtil;
import com.max.slw.dao.Hutoolway;
import com.max.slw.dao.Person;
import com.max.slw.dao.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="UserUpdateApi",urlPatterns = "/UserUpdateApi")
public class UserUpdateApi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String id = req.getParameter("id");
        Hutoolway hutoolway =new Hutoolway();
        User user= new User();
        user.setId(id);
        int result=hutoolway.Update(user,name);
        boolean blres = (result != 0);
        var bean = new DemoBean();
        bean.setRes(blres);
        String json= JSONUtil.toJsonStr(bean);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();

    }
}
