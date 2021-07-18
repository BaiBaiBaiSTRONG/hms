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

@WebServlet(name="UserOperateApi",urlPatterns = "/UserDeleteApi")
public class UserDeleteApi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Hutoolway hutoolway =new Hutoolway();
        User user= new User();
        user.setName(name);
        int result=hutoolway.Delete(user);
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
