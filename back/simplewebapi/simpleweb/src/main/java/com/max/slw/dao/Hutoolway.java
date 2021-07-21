package com.max.slw.dao;

import cn.hutool.db.Db;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class Hutoolway {
    public List<cn.hutool.db.Entity> tablequery() {
        List<cn.hutool.db.Entity> list=null;
        try {

            list = Db.use().query("select * from myuser where id=?","zhangsan1");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;


    }
    public int insert(User user)
    {
        String id= UUID.randomUUID().toString();
        try {
            int var=Db.use().execute("insert into myuser values(?,?)",id,user.getName());
            return var;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    public int Delete(User user)
    {
        try {
            int var=Db.use().execute("delete from myuser where name=?",user.getName());
            return var;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    public int Update(User user,String name)
    {
        try {
            int var=Db.use().execute("update myuser set name =? where id=?",name,user.getId());
            return var;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
