package com.max.slw.api;

import cn.hutool.json.JSONUtil;
<<<<<<< HEAD:back/simpleweb/src/main/java/com/max/slw/api/Roomupdateapi.java
import com.max.slw.api.DemoBean;
import com.max.slw.dao.*;
=======
import com.max.slw.dao.FunctionsforProgramme;
import com.max.slw.dao.Hutoolway;

import com.max.slw.dao.Room;
import com.max.slw.dao.User;
>>>>>>> 9bd6bd0b8cf3c20993e99c0646aabf4a9be1ac5d:back/simpleweb/src/main/java/com/max/slw/api/Fulldeleteapi.java

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

<<<<<<< HEAD:back/simpleweb/src/main/java/com/max/slw/api/Roomupdateapi.java
@WebServlet(name="Roomupdateapi",urlPatterns = "/Roomupdateapi")
public class Roomupdateapi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String updatetype = req.getParameter("updatetype");
        String updatecontent = req.getParameter("updatecontent");
        String roomid = req.getParameter("roomid");
        System.out.println(updatetype);
        System.out.println(roomid);
        FunctionsforProgramme way = new FunctionsforProgramme();
        Room room=new Room();
        room.setRoomid(Integer.parseInt(roomid));
        int result = way.roomupdate(room,updatetype,updatecontent);
=======
@WebServlet(name="Fulldeleteapi",urlPatterns = "/Fulldeleteapi")
public class Fulldeleteapi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tabletype=req.getParameter("tabletype");
        String identifier = req.getParameter("identifier");
        FunctionsforProgramme way = new FunctionsforProgramme();
        int result=way.Fulldelete(tabletype,identifier);
>>>>>>> 9bd6bd0b8cf3c20993e99c0646aabf4a9be1ac5d:back/simpleweb/src/main/java/com/max/slw/api/Fulldeleteapi.java
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
