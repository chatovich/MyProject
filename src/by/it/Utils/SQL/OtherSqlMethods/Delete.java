package by.it.Utils.SQL.OtherSqlMethods;

import by.it.Utils.SQL.CN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by Admin on 04.04.2016.
 */
public class Delete {
    public static void DelFromUsers(Integer id_user){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "DELETE FROM users "+
                            "WHERE id.user="+id_user+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void DelFromSubstancesOfRoom(Integer id_substancesOfRoom){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "DELETE FROM substancesOfRoom "+
                            "WHERE id.substancesOfRoom="+id_substancesOfRoom+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void DelFromRoom(Integer id_room){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "DELETE FROM room "+
                            "WHERE id.room="+id_room+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void DelFromFlammableSubstance(Integer id_substance){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "DELETE FROM flammablesubstance "+
                            "WHERE id.substance="+id_substance+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void DelFromCoefficientsForRoom(Integer id_coefficientsforroom){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "DELETE FROM coefficientsforroom "+
                            "WHERE id.coefficientsforroom="+id_coefficientsforroom+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void DelFromCoefficientsForBuilding(Integer id_coefficientSForBuilding){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "DELETE FROM coefficientsforbuilding "+
                            "WHERE id.coefficientSForBuilding="+id_coefficientSForBuilding+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void DelFromChangesInMeanBulkTemperature(Integer id_changesinmeanbulktemperature){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "DELETE FROM changesinmeanbulktemperature "+
                            "WHERE id.changesinmeanbulktemperature="+id_changesinmeanbulktemperature+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void DelFromChangeInAverageTemperatureOfWalls(Integer id_changeinaveragetemperatureofwalls){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "DELETE FROM changeinaveragetemperatureofwalls "+
                            "WHERE id.changeinaveragetemperatureofwalls="+id_changeinaveragetemperatureofwalls+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void DelFromChangeInAverageTemperatureOfSlab(Integer id_changeinaveragetemperatureofslab){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "DELETE FROM changeinaveragetemperatureofslab "+
                            "WHERE id.changeinaveragetemperatureofslab="+id_changeinaveragetemperatureofslab+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void DelFromBuilding(Integer id_building){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "DELETE FROM building "+
                            "WHERE id.building="+id_building+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void DelFromAperture(Integer id_aperture){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "DELETE FROM aperture "+
                            "WHERE id.aperture="+id_aperture+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void DelFromAllBuildings(Integer id_allbuildings){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "DELETE FROM allbuildings "+
                            "WHERE id.allbuildings="+id_allbuildings+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
