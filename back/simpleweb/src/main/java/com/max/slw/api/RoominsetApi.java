package com.max.slw.api;

import cn.hutool.json.JSONUtil;
import com.max.slw.dao.FunctionsforProgramme;
import com.max.slw.dao.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.server.ServerCloneException;

@WebServlet(name = "RoominsertApi",urlPatterns = "/Roominsertapi")
public class RoominsetApi extends HttpServlet {
    @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
            String roomid = req.getParameter("roomid");
            String roomname = req.getParameter("roomname");
            String buildingid=req.getParameter("buildingid");
            String ownerid=req.getParameter("ownerid");
            String area=req.getParameter("area");
            String tenement=req.getParameter("tenement");
            String status= req.getParameter("status");
            FunctionsforProgramme way=new FunctionsforProgramme();
        System.out.println(roomid);
        System.out.println(roomname);
        System.out.println(buildingid);
        System.out.println(ownerid);
        System.out.println(area);
        System.out.println(tenement);
        System.out.println(status);

            Room room= new Room(Integer.parseInt(roomid),roomname,Integer.parseInt(buildingid),Integer.parseInt(ownerid),Integer.parseInt(area),tenement,status);
            int result = way.insertroom(room);
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
