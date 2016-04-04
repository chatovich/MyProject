package by.it.Utils.JD03_01.Examples;

import by.it.Utils.JD03_01.CN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Ex_02_Insert_AD {


    public static void main(String[ ] args) {
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement();) {

            //вставляем объявления
            statement.executeUpdate(
                    "INSERT INTO ad (RoomCount, Price, Area, Floor, Floors, Address, FK_Users, Description) "+
                            "VALUES (2, 65000, '42', 3, 5, 'Knorina 18', 1, 'Good flat');"
            );
            statement.executeUpdate(
                    "INSERT INTO ad (RoomCount, Price, Area, Floor, Floors, Address, FK_Users, Description) "+
                    "VALUES (2, 85000, '42', 3, 5, 'Nezavisimosti 35', 1, 'Elit app.');");
            statement.executeUpdate(
                    "INSERT INTO ad (RoomCount, Price, Area, Floor, Floors, Address, FK_Users, Description) "+
                    "VALUES (2, 45000, '42', 1, 1, 'Murova 5', 1, 'Far app.');"            );
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
