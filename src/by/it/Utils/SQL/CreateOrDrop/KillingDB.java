package by.it.Utils.SQL.CreateOrDrop;

import by.it.Utils.SQL.CN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Drop all tables of DB
 */
public class KillingDB {

    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            Statement statement = connection.createStatement()) {
            // statement.executeUpdate("drop database engineering1;");

            statement.executeUpdate("drop table changeinmeanbulktemperature;");
            statement.executeUpdate("drop table changeintemperatureofwalls;");
            statement.executeUpdate("drop table changeintemperatureofslab;");
            statement.executeUpdate("drop table substancesofroom;");
            statement.executeUpdate("drop table flammablesubstance;");
            statement.executeUpdate("drop table coefficientsforroom;");
            statement.executeUpdate("drop table coefficientsforbuilding;");
            statement.executeUpdate("drop table aperture;");
            statement.executeUpdate("drop table room;");
            statement.executeUpdate("drop table building;");
            statement.executeUpdate("drop table users;");

            System.out.println("Tables from DB were deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
