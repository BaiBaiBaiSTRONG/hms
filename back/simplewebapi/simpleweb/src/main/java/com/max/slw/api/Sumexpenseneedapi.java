package com.max.slw.api;

import cn.hutool.json.JSONUtil;
import com.max.slw.dao.FunctionsforProgramme;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="Sumexpenseneedapi",urlPatterns = "/Sumexpenseneedapi")
public class Sumexpenseneedapi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ownerid=req.getParameter("ownerid");
        FunctionsforProgramme way=new FunctionsforProgramme();
        int result=0;
        result=way.quaryData(ownerid);
        System.out.println(result);

        var sum = new Sum();
        sum.setResult(result);
        String json= JSONUtil.toJsonStr(sum);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();
    }
}
