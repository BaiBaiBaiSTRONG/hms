package com.max.slw.api;

import cn.hutool.json.JSONUtil;
import com.max.slw.api.DemoBean;
import com.max.slw.dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="Fullupdateapi",urlPatterns = "/Fullupdateapi")
public class Fullupdateapi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pointer = req.getParameter("pointer");
        String tabletype = req.getParameter("tabletype");
        String updatetype = req.getParameter("updatetype");
        String updatecontent = req.getParameter("updatecontent");
        System.out.println(pointer);
        FunctionsforProgramme way = new FunctionsforProgramme();
        int result = way.Fullupdate(pointer,tabletype,updatetype,updatecontent);
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
