package by.it.Utils.JD03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Kill DB
 */
public class KillingDB {

    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            Statement statement = connection.createStatement()) {
            statement.executeUpdate("drop database engineering1;");
            /*statement.executeUpdate("drop table substancesofroom;");
            statement.executeUpdate("drop table room;");
            statement.executeUpdate("drop table flammablesubstance;");
            statement.executeUpdate("drop table coefficientsforroom;");
            statement.executeUpdate("drop table coefficientsforbuilding;");
            statement.executeUpdate("drop table building;");
            statement.executeUpdate("drop table aperture;");

            statement.executeUpdate("drop table allbuildings;");*/



            //statement.executeUpdate("drop database searchhost_java;");

            System.out.println("Tables from DB searchhost_java were deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
