package asd;

import cn.hutool.db.Db;
import com.max.slw.dao.User;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.parser.Entity;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class Hutooltest {
    @Test
    public List<cn.hutool.db.Entity> tablequery() {
        List<cn.hutool.db.Entity> list=null;
        try {

            list = Db.use().query("select * from myuser where id=?","zhangsan1");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;


    }
    @Test
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
    @Test
    public void Delete(User user)
    {
        try {
            Db.use().execute("delete from myuser where id=?",user.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Test
    public void Update(User user,String name)
    {
        try {
            Db.use().execute("update myuser set name =? where id=?",name,user.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
