package by.it.Utils.JD03_01;

import java.sql.Connection;
import java.sql.DriverManager;

public class Ex_01_Connection {


    public static void main(String[ ] args) {
            //устаревший способ регистрации. Сейчас уже не требуется.
            //Driver driver=new FabricMySQLDriver();
            //DriverManager.registerDriver(driver);
            try (Connection connection=
                         DriverManager.getConnection
                                 (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB)) {
                if (!connection.isClosed())
                    System.out.println("Соединение установлено");
                connection.close();
                if (connection.isClosed())
                    System.out.println("Соединение прервано");
            }
            catch (Exception e){
                e.printStackTrace();
            }

    }
}
