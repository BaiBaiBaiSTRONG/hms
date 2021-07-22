package com.max.slw.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FunctionsforProgramme {


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
    public List<Entity> Fullquery(String tabletype,String querytype,String querycontent) throws SQLException
    {
        List<Entity> list = null;
        list = Db.use().query("select * from "+tabletype+" where "+querytype +"=?",querycontent);
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
    public int expenseinsert(String expenseid,String expenseall,String expenseneed,String ownerid,String expensetype,String edate) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            int var=Db.use().execute("insert into expense values(?,?,?,?,?,?)",Integer.parseInt(expenseid),Integer.parseInt(expenseall),Integer.parseInt(expenseneed),Integer.parseInt(ownerid),expensetype,simpleDateFormat.parse(edate));
            return var;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    public int feesum(String ownerid){return 0;};
    public List<Entity> expensequery(String querytype,String querycontent){List<Entity> list=null;return list;};
    public List<Entity> expensebyperiod(Date date1,Date date2){List<Entity> list=null;return list;};
    public int updateexpense(Expense expense,String updatetype,String updatecontent){return 0;};
    public List<Entity> officequery(String querytype,String querycontent){List<Entity> list=null;return list;};
    public int officeupdate(String officeid,String updatetype,String updatecontent ){return 0;}
    public int parkingupdate(String Parkingid,String updatetype,String updatecontent){return 0;};
    public int ownerinsert(String ownerid,String ownername,String age,String status) throws ParseException {
        try {
            int var=Db.use().execute("insert into expense values(?,?,?,?)",Integer.parseInt(ownerid),ownername,Integer.parseInt(age),Integer.parseInt(status));
            return var;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    public int parkinginsert(String parkingid,String parkinglot,String ownerid,String duedate,String status,String username) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            int var=Db.use().execute("insert into parking values(?,?,?,?,?,?)",Integer.parseInt(parkingid),parkinglot,Integer.parseInt(ownerid),simpleDateFormat.parse(duedate),status,username);
            return var;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    public int staffinsert(String staffid,String staffname,String staffjob,String officeid,String department) throws ParseException {
        try {
            int var=Db.use().execute("insert into parking values(?,?,?,?,?)",Integer.parseInt(staffid),staffname,staffjob,officeid,department);
            return var;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    public int recordinsert(String recordid,String recordname,String content,String staffid) throws ParseException {
        try {
            int var=Db.use().execute("insert into parking values(?,?,?,?)",Integer.parseInt(recordid),recordname,content,Integer.parseInt(staffid));
            return var;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    public int quaryData(String ownerid) {
        Connection connection = null; //alt +enter split into
        //load driver if exception go for try catch and you'll be fine
        int sum=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //connect to db
            String url = "jdbc:mysql://127.0.0.1:3306/hms?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
            connection = DriverManager.getConnection(url, "root", "123456");
            //bulid A object to operate on
            PreparedStatement preparedStatement = connection.prepareStatement("select sum(expenseneed) from expense where ownerid=?");
            //conduct insert statement
            preparedStatement.setString(1, ownerid);//for value 1 uuid not stirng to string
            ResultSet rs= preparedStatement.executeQuery();//for value 2
            List<User> list=new ArrayList<>();
            while(rs.next()) {
                sum=rs.getInt(1);
                System.out.println(sum);
            }

            //none
            //release resources
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return sum;
    }
    public List<Entity>  expenseneedquery(String ownerid)
    {
        List<Entity> list =null;
        try {
            list=Db.use().query("select ownerid,sum(expenseneed) from expense where ownerid=?",ownerid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;

    }
    public List<Entity> billsbydate(String date1,String date2)
    {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

        List<Entity> list =null;
        try {
            list=Db.use().query("select expenseid,expenseall,expenseneed,ownerid,ownername,expensetype,edate from expense inner join owner using (ownerid) where edate between ? and ?",simpleDateFormat.parse(date1),simpleDateFormat.parse(date2));
        } catch (SQLException | ParseException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public List<Entity>  expensegroupby()
    {
        List<Entity> list =null;

        try {
            list=Db.use().query("select ownerid, ownername, sum(expenseneed) as sumneed, sum(expenseall) as sumall from expense inner join owner using (ownerid) group by ownerid, ownername");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;

    }
    public List<Entity> Fullqueryv2(String selection,String tabletype,String querytype,String querycontent) throws SQLException
    {
        List<Entity> list = null;
        list = Db.use().query("select "+selection+" from "+tabletype+" where "+querytype +"=?",querycontent);
        return list;
    }
     public List<Entity> Fullquery2(String tabletype,String querytype1,String querytype2,String querycontent1,String querycontent2) throws SQLException
    {
        List<Entity> list = null;
        list = Db.use().query("select * from "+tabletype+" where ("+querytype1 +"=?"+")and("+querytype2+"=?)",querycontent1,querycontent2);
        return list;
    }

    public int securityinsert(String securityid,String securityname,String score,String issue,String checkstatus,String staffid,String sdate) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            int var=Db.use().execute("insert into security values(?,?,?,?,?,?,?)",Integer.parseInt(securityid),securityname,Integer.parseInt(score),Integer.parseInt(issue),Integer.parseInt(checkstatus),Integer.parseInt(staffid),simpleDateFormat.parse(sdate));
            return var;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public int issueinsert(String issueid,String issuename,String securityid,String content) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            int var=Db.use().execute("insert into issue values(?,?,?,?)",Integer.parseInt(issueid),issuename,Integer.parseInt(securityid),content);
            return var;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public int officeinsert(String officeid,String filesnum,String keysnum,String status) throws ParseException {
        try {
            int var=Db.use().execute("insert into office values(?,?,?,?)",Integer.parseInt(officeid),Integer.parseInt(filesnum),Integer.parseInt(keysnum),status);
            return var;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public int cleaninginsert(String cleaningid,String cleaningname,String cleaningtime,String cleaningstatus,String cdate,String staffid

    ) throws ParseException { SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            int var=Db.use().execute("insert into cleaning values(?,?,?,?,?,?)",Integer.parseInt(cleaningid),cleaningname,simpleDateFormat.parse(cleaningtime),Integer.parseInt(cleaningstatus),simpleDateFormat.parse(cdate),Integer.parseInt(staffid));
            return var;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    public int requestinsert(String requestid,String requestcontent,String requesttype,String requestsatatus,String staffid,String ownerid

    ) throws ParseException {
        try {
            int var=Db.use().execute("insert into cleaning values(?,?,?,?,?,?)",Integer.parseInt(requestid),requestcontent,requesttype,requestsatatus,staffid,Integer.parseInt(ownerid));
            return var;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}

