package asd;

import cn.hutool.db.Db;
import com.max.slw.dao.Room;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class insertTest {
    public static int Roomid;
    @Test
    public void insertroom()
    {
        Roomid = Roomid+1;
        try {
            int var = Db.use().execute("insert into ROOM values(?,?,?,?,?,?,?)",Roomid,"spring",1,1,12,"sold","developed");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
