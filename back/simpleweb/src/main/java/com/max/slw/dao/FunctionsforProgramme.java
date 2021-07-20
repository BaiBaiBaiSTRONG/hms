package com.max.slw.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class FunctionsforProgramme {

    public List<Entity> roomquery(int a) throws SQLException {
        List<Entity> list = null;
        list = Db.use().query("select roomid,roomname,buildingid,ownerid,area,tenement,status from room natural join building where buildingid =?",a);
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
    public int deleteroom(Room room){
        try {
            int var = Db.use().execute("delete from room where roomid=?",room.getRoomid());
                    return var;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }
    public int updateroomname(Room room,String name){
        try {
            int var=Db.use().execute("update room set roomname=? where roomid=?",name,room.getRoomid());
            return var;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }

    }
    public int updateownerid(Room room,String ownerid){
        try {
            int var=Db.use().execute("update room set ownerid=? where roomid=?",Integer.parseInt(ownerid),room.getRoomid());
            return var;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }

    }
    public int Fullupdate(String pointer,String tabletype,String updatetype,String updatecontent)
    {
        String tabletypeid=tabletype+"id";
        try {
            int var=Db.use().execute("update "+tabletype+" set "+updatetype+"=? where "+tabletypeid+"=?",updatecontent,pointer);
            return var;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }


    }
    public List<Entity> roomquery(String tabletype,String querytype,String querycontent) throws SQLException
    {
        List<Entity> list = null;
        list = Db.use().query("select roomid,roomname,buildingid,ownerid,area,tenement,status from "+tabletype+" where "+querytype +"=?",querycontent);
        return list;
    }
    /*public int feesum(String ownerid){return 0;};
    public List<Entity> expensequery(String querytype,String querycontent){List<Entity> list=null;return list;};
    public List<Entity> expensebyperiod(Date date1,Date date2){List<Entity> list=null;return list;};
    //public int updateexpense(Expense expense,String updatetype,String updatecontent){return 0;};
    public List<Entity> officequery(String querytype,String querycontent){List<Entity> list=null;return list;};
    public int officeupdate(String officeid,String updatetype,String updatecontent ){return 0;}
    public int officeinsert(String officeid,String filesum,String keysum,String status){return 0;};
    public int parkingupdate(String Parkingid,String updatetype,String updatecontent){return 0;};*/



}

