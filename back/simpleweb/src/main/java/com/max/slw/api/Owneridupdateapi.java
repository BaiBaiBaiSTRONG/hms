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

@WebServlet(name="Owneri1dupdateapi",urlPatterns = "/Owneri1dupdateapi")
public class Owneridupdateapi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hahahaah");
        String ownerid = req.getParameter("ownerid");
        String roomid = req.getParameter("roomid");
        System.out.println(ownerid);
        System.out.println(roomid);
        FunctionsforProgramme way = new FunctionsforProgramme();
        Room room= new Room();
        room.setRoomid(Integer.parseInt(roomid));
        int result = way.updateownerid(room,ownerid);
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
