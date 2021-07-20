package com.max.slw.api;

import cn.hutool.json.JSONUtil;
import com.max.slw.dao.FunctionsforProgramme;
import com.max.slw.dao.Room;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.server.ServerCloneException;
import java.text.ParseException;

@WebServlet(name = "Staffinsertapi",urlPatterns = "/Staffinsertapi")
public class Staffinsertapi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String staffid = req.getParameter("staffid");
        String staffname = req.getParameter("staffname");
        String staffjod=req.getParameter("staffjob");
        String officeid=req.getParameter("officeid");
        String department=req.getParameter("department");
        FunctionsforProgramme way=new FunctionsforProgramme();
        int result = 0;
        try {
            result = way.staffinsert(staffid,staffname,staffjod,officeid,department);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean blres = (result!=0);
        var bean = new DemoBean();
        bean.setRes(blres);
        String json= JSONUtil.toJsonStr(bean);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();


    }
}
