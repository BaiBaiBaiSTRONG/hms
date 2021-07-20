package com.max.slw.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class FunctionsforProgramme {

<<<<<<< HEAD
    public List<Entity> roomquery(int a) throws SQLException {
        List<Entity> list = null;
        list = Db.use().query("select roomid,roomname,bulidingid,ownerid,area,tenement,status from owner natural join room natural join expense natural join building natural join parking natural join request where building id =?","");
        return list;
    }
=======

>>>>>>> 9bd6bd0b8cf3c20993e99c0646aabf4a9be1ac5d
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
<<<<<<< HEAD
    public int roomupdate(Room room,String updatetype,String updatecontent)
    {
        try {
            int var=Db.use().execute("update room set "+updatetype+"=? where roomid=?",updatecontent,room.getRoomid());
=======


    public int Fullupdate(String pointer,String tabletype,String updatetype,String updatecontent)
    {
        String tabletypeid=tabletype+"id";
        try {
            int var=Db.use().execute("update "+tabletype+" set "+updatetype+"=? where "+tabletypeid+"=?",updatecontent,pointer);
>>>>>>> 9bd6bd0b8cf3c20993e99c0646aabf4a9be1ac5d
            return var;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }


    }
    public List<Entity> Fullquery(String tabletype,String querytype,String querycontent) throws SQLException
    {
        List<Entity> list = null;
        list = Db.use().query("select roomid,roomname,buildingid,ownerid,area,tenement,status from "+tabletype+" where "+querytype +"=?",querycontent);
        return list;
    }
    public int Fulldelete(String tabletype,String identifier)
    {
        String tableid= tabletype+"id";
        try {
            int var=Db.use().execute("delete from "+tabletype+" where "+tableid+"=?",identifier);
            return var;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }
<<<<<<< HEAD


    public int deletebuilding(Building building) {
        try {
            int var = Db.use().execute("delete from building where buildingid=?", building.getBuildingid());
            return var;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }
    public int buildingupdate(Building building,String updatetype,String updatecontent)
    {
        try {
            int var=Db.use().execute("update building set "+updatetype+"=? where buildingid=?",updatecontent,building.getBuildingid());
            return var;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }


    }
=======
    public int feesum(String ownerid){return 0;};
    public List<Entity> expensequery(String querytype,String querycontent){List<Entity> list=null;return list;};
    public List<Entity> expensebyperiod(Date date1,Date date2){List<Entity> list=null;return list;};
    public int updateexpense(Expense expense,String updatetype,String updatecontent){return 0;};
    public List<Entity> officequery(String querytype,String querycontent){List<Entity> list=null;return list;};
    public int officeupdate(String officeid,String updatetype,String updatecontent ){return 0;}
    public int officeinsert(String officeid,String filesum,String keysum,String status){return 0;};
    public int parkingupdate(String Parkingid,String updatetype,String updatecontent){return 0;};



>>>>>>> 9bd6bd0b8cf3c20993e99c0646aabf4a9be1ac5d
}



