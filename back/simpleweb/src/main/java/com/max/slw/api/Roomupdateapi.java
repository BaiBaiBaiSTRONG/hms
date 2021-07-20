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

@WebServlet(name="Roomnameupdateapi",urlPatterns = "/Roomnameupdateapi")
public class Roomnameupdateapi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roomname = req.getParameter("roomname");
        String roomid = req.getParameter("roomid");
        FunctionsforProgramme way = new FunctionsforProgramme();
        Room room=new Room();
        room.setRoomid(Integer.parseInt(roomid));
       int result = way.updateroomname(room,roomname);
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
