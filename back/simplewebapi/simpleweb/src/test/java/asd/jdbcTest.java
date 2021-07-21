package asd;

import com.max.slw.dao.User;
import com.mysql.cj.protocol.Resultset;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

public class jdbcTest {
    @Test
    public void insertMyuser() {
        Connection connection = null; //alt +enter split into
        //load driver if exception go for try catch and you'll be fine

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //connect to db
            String url = "jdbc:mysql://127.0.0.1:3306/myuse";
            connection = DriverManager.getConnection(url, "root", "123456");
            //bulid A object to operate on
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO myuser VALUES(?,?)");
            //conduct insert statement
            preparedStatement.setString(1, UUID.randomUUID().toString());//for value 1 uuid not stirng to string
            preparedStatement.setString(2, "zhangsan2");//for value 2
            preparedStatement.executeUpdate();//for insert update delete not quary  return the number of execution
            System.out.println("successfully inserted");
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
    }
    @Test
    public void quaryData() {
        Connection connection = null; //alt +enter split into
        //load driver if exception go for try catch and you'll be fine

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //connect to db
            String url = "jdbc:mysql://127.0.0.1:3306/myuse?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
            connection = DriverManager.getConnection(url, "root", "123456");
            //bulid A object to operate on
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM myuser WHERE name LIKE ?");
            //conduct insert statement
            preparedStatement.setString(1, "%二%");//for value 1 uuid not stirng to string
            ResultSet rs= preparedStatement.executeQuery();//for value 2
            List<User> list=new ArrayList<>();
            while(rs.next()) {
                String id=rs.getString(1);
                String name=rs.getString(2);
                User user = new User();
                user.setId(id);
                user.setName(name);
                list.add(user);
                System.out.println(id+":"+name);
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
    }
    @Test
    public void updatetable() {
        Connection connection = null; //alt +enter split into
        //load driver if exception go for try catch and you'll be fine

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //connect to db
            String url = "jdbc:mysql://127.0.0.1:3306/myuse?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
            connection = DriverManager.getConnection(url, "root", "123456");
            //bulid A object to operate on
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE myuser SET name=? where id=?");
            //conduct insert statement
            preparedStatement.setString(1, "%芜湖%");//for value 1 uuid not stirng to string
            preparedStatement.setString(2, "a706e21d-ae1b-4a98-a57a-1c4e3e8cc6d5");
            preparedStatement.executeUpdate();

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
    }
     @Test
        public void deletetable() {
        Connection connection = null; //alt +enter split into
        //load driver if exception go for try catch and you'll be fine

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //connect to db
            String url = "jdbc:mysql://127.0.0.1:3306/myuse?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
            connection = DriverManager.getConnection(url, "root", "123456");
            //bulid A object to operate on
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM myuser WHERE name=?");
            //conduct insert statement
            preparedStatement.setString(1, "%芜湖%");//for value 1 uuid not stirng to string
            preparedStatement.executeUpdate();

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
    }


}

