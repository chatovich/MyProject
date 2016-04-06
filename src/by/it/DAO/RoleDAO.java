package by.it.DAO;

import by.it.Utils.SQL.Xampp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleDAO extends DAO {

    //этот класс получает готовые данные из справочника
    Integer getID(String strRole) throws SQLException {
        //Read
        Integer res = null;
        String sql = "SELECT ID FROM Role WHERE Role=`" + strRole + "`;";
        try (Connection connection = Xampp.getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) res = rs.getInt("ID");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    String getRole(Integer id) throws SQLException {
        //Read
        String res = null;
        String sql = "SELECT * FROM Role WHERE ID=" + id + ";";
        try (Connection connection = Xampp.getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) res = rs.getString("Role");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }




}
