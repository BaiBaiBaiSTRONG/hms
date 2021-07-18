package com.max.slw.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;

import java.sql.SQLException;
import java.util.List;

public class FunctionsforProgramme {

    public List<Entity> roomquery(int a) throws SQLException {
        List<Entity> list = null;
        list = Db.use().query("select roomid,roomname,bulidingid,ownerid,area,tenement,status from owner natural join room natural join expense natural join building natural join parking natural join request where building id =?","");
        return list;
    }
    public int insertroom(Room room)
    {
        try {
            int var = Db.use().execute("insert into ROOM values(?,?,?,?,?,?,?)",room.getRoomid(),room.getRoomname(),room.getBuildingid(),room.getOwnerid(),room.getArea(),room.getTenement(),room.getStatus());
            System.out.println(room.getRoomid() + room.getOwnerid());
            return var;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    //public int deleteroom(Room room){}
}

