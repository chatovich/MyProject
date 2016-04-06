package by.it.Utils.SQL.CreateOrDrop;

import by.it.Utils.SQL.CN;
import by.it.Utils.SQL.Xampp;

import java.sql.*;


/**
 * DB Creation
 */
public class DB_Creation {

    public static void main(String[] args) {

        try(//Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            Connection connection = Xampp.getConnection();
            Statement statement = connection.createStatement()) {

            QueriesForDB_Creation.createTable(statement);
            QueriesForDB_Creation.insertData();
            //QueriesForDB_Creation.showTables(statement);
           // System.out.println("Database searchhost_java was created");


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
