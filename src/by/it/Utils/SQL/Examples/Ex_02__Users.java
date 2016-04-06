package by.it.Utils.SQL.Examples;

import by.it.Utils.SQL.CN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Ex_02__Users {


    public static void main(String[ ] args) {
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            //вставляем пользователей
            statement.executeUpdate(
                    "insert into users(Login,Password,Email)"+
                            " values('admin2','admin2','admin2@tut.by');"
            );
            statement.executeUpdate(
                    "insert into users(Login,Password,Email)"+
                            " values('avkhmeleva','pavkhmeleva','avkhmeleva@tut.by');"
            );
        }

        catch (Exception e){
            e.printStackTrace();
        }

    }
}
