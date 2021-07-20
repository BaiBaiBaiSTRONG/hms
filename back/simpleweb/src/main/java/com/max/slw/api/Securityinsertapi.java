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

@WebServlet(name = "Securityinsertapi",urlPatterns = "/Securityinsertapi")
public class Securityinsertapi extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String securityid = req.getParameter("securityid");
        String securityname = req.getParameter("securityname");
        String score=req.getParameter("score");
        String issue=req.getParameter("issue");
        String checkstatus=req.getParameter("checkstatus");
        String staffid=req.getParameter("staffid");
        String sdate=req.getParameter("sdate");
        FunctionsforProgramme way=new FunctionsforProgramme();
        int result = 0;
        try {
            result = way.securityinsert(securityid,securityname,score,issue,checkstatus,staffid,sdate);
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