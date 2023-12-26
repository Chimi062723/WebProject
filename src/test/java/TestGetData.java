import com.example.webproject.model.User;
import com.example.webproject.util.DBhelper;
import com.example.webproject.util.JDBCHelper;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TestGetData {
    @Test
    public void testgetReviewByJDBCHelper(){
        long start = System.currentTimeMillis();
        List<User> users = new ArrayList<>();
        try (Connection connection = JDBCHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Users")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setUserName(rs.getString("UserName"));
                user.setPassword(rs.getString("Password"));
                user.setEmail(rs.getString("Email"));
                user.setRole(rs.getString("Role"));
                user.setCreateDate(rs.getTimestamp("CreateDate"));
                users.add(user);
            }
            System.out.println(System.currentTimeMillis()-start);
        } catch (SQLException e) {
            Logger.getLogger("SQLERROR"+e);
        }
        System.out.println(users);
    }
    @Test
    public void testgetReviewByDBhelper(){
        long start = System.currentTimeMillis();
        List<User> users = new ArrayList<>();
        DBhelper dBhelper = new DBhelper();
        dBhelper.init();
        try (Connection connection = dBhelper.dbconn;
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Users")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setUserName(rs.getString("UserName"));
                user.setPassword(rs.getString("Password"));
                user.setEmail(rs.getString("Email"));
                user.setRole(rs.getString("Role"));
                user.setCreateDate(rs.getTimestamp("CreateDate"));
                users.add(user);
            }
            System.out.println(System.currentTimeMillis()-start);
        } catch (SQLException e) {
            Logger.getLogger("SQLERROR"+e);
        }
        System.out.println(users);
    }
}
