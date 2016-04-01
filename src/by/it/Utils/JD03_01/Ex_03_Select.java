package by.it.Utils.JD03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex_03_Select {


    public static void main(String[ ] args) {
            try (Connection connection=
                         DriverManager.getConnection
                                 (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
                 Statement statement=connection.createStatement();) {
                //получаем пользователей
                ResultSet resultSet=statement.executeQuery("select * from users;");
                while (resultSet.next()){
                    String out=resultSet.getString("Email")+", "+resultSet.getString("Login");
                    System.out.println(out);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
    }
}
