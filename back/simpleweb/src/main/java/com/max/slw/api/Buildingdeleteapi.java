package com.max.slw.api;

import cn.hutool.json.JSONUtil;
import com.max.slw.dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="Buildingdeleteapi",urlPatterns = "/Buildingdeleteapi")
public class Buildingdeleteapi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String buildingid = req.getParameter("buildingid");//String getParameter(String name):根据参数名称获取参数值
        FunctionsforProgramme way = new FunctionsforProgramme();//每一个里面都要写
        Building building= new Building();
        building.setBuildingid(Integer.parseInt(buildingid));//转成int型 this.roomid=roomid;
        int result=way.deletebuilding(building);//@@@@@@@@@@@@用于检测传值有没有成功，没有成功的话会报错
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
