package by.it.Utils.JD03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Ex_02__Users {


    public static void main(String[ ] args) {
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement();) {
            //вставляем пользователей
            statement.executeUpdate(
                    "insert into users(Login,Password,Email,Role)"+
                            " values('admin2','admin2','admin2@tut.by','administrator');"
            );
            statement.executeUpdate(
                    "insert into users(Login,Password,Email,Role)"+
                            " values('avkhmeleva','pavkhmeleva','avkhmeleva@tut.by','administrator');"
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
