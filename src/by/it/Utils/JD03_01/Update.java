package by.it.Utils.JD03_01;

import by.it.generate.Aperture;
import by.it.generate.Building;
import by.it.generate.Room;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Admin on 04.04.2016.
 */
public class Update {
    public static void UpdToUsers(String login,String password,String email,Integer id_user){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "UPDATE users SET login="+login+", SET password="+password+", SET email="+email+" "+
                            "WHERE id.user="+id_user+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void UpdToSubstancesOfRoom(Integer id_substance,Integer id_room,Double weight,Integer id_substancesOfRoom){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "UPDATE substancesofroom SET fk.id.substance="+id_substance+", SET fk.id.room="+id_room+
                            ", SET weight="+weight+" "+
                            "WHERE id.substancesOfRoom="+id_substancesOfRoom+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void UpdToFlammableSubstance(String name,Double amountOfCombustionAir,Double combustionHeat,Double averageSpeedBurnout,Integer id_substance){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "UPDATE flammablesubstance SET name="+name+",SET amountOfCombustionAir="+amountOfCombustionAir+"," +
                            "SET combustionHeat="+combustionHeat+",SET averageSpeedBurnout="+averageSpeedBurnout+" "+
                            "WHERE id.substance="+id_substance+" ;");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }/*
    public static void UpdToRoom(String position,String name,Double square,Double height,Double perimeter,
                                 Double volume,Double squareOfConstruction,Double specificFireLoad,Double reducedHeightOfApertures,
                                 Double generalSquareOfApertures,Double ventilationParameter,Double coefficientK,Double coefficientA,
                                 Double coefficientB,Double coefficientS,Double estimatedFireLoad,Double proemnostOfRoom,
                                 Double averageAmountOfCombustionAir, Double specificCriticalAmountOfFireLoad,
                                 Double specificValueOfFireLoad,Boolean PRN,Double maximumMeanBulkTemperature,
                                 Double durationOfFireSurround,Double timeReachMaximumMeanBulkTemperature,
                                 Double maximumAverageTemperatureOfWallSurface,Double timeToReachMaximumTemperatureOfWallSurface,
                                 Double averageMaximumTemperatureOfSlab,Double timeToReachMaximumTemperatureOfSlabSurface){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "INSERT INTO room (position, name, square,height,perimeter,volume,squareOfConstruction,specificFireLoad, +\n" +
                            "                           reducedHeightOfApertures,generalSquareOfApertures,ventilationParameter,coefficientK,coefficientA, +\n" +
                            "                           coefficientB,coefficientS,estimatedFireLoad,proemnostOfRoom,averageAmountOfCombustionAir, +\n" +
                            "                           specificCriticalAmountOfFireLoad,specificValueOfFireLoad,PRN,maximumMeanBulkTemperature, +\n" +
                            "                           durationOfFireSurround,timeReachMaximumMeanBulkTemperature,maximumAverageTemperatureOfWallSurface, +\n" +
                            "                           timeToReachMaximumTemperatureOfWallSurface,averageMaximumTemperatureOfSlab, +\n" +
                            "                           timeToReachMaximumTemperatureOfSlabSurface) "+
                            "VALUES ("+position+","+name+","+square+","+height+","+perimeter+","+volume+","+squareOfConstruction+
                            ","+specificFireLoad+","+reducedHeightOfApertures+","+generalSquareOfApertures+","+ventilationParameter+
                            ","+coefficientK+","+coefficientA+","+coefficientB+","+coefficientS+","+
                            estimatedFireLoad+","+proemnostOfRoom+","+averageAmountOfCombustionAir+","+
                            specificCriticalAmountOfFireLoad+","+specificValueOfFireLoad+","+PRN+","+
                            maximumMeanBulkTemperature+","+durationOfFireSurround+","+timeReachMaximumMeanBulkTemperature+
                            ","+maximumAverageTemperatureOfWallSurface+","+timeToReachMaximumTemperatureOfWallSurface+","+
                            averageMaximumTemperatureOfSlab+","+timeToReachMaximumTemperatureOfSlabSurface+");");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }*/
    public static void UpdToRoom(Room r, Integer id_building,Integer id_room){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "UPDATE room SET position="+r.getCommonParameters().getPosition()+",SET name="+r.getCommonParameters().getName()+
                            ",SET square="+r.getCommonParameters().getSquare()+",SET height="+r.getCommonParameters().getHeight()+
                            ",SET perimeter="+r.getCommonParameters().getPerimeter()+"," +
                            "SET volume="+r.getCommonParameters().getVolume()+
                            ",SET squareOfConstruction="+r.getCommonParameters().getSquareOfConstruction()+
                            ",SET specificFireLoad="+r.getParametersCalculatedFireLoad().getSpecificFireLoad()+"," +
                            "SET reducedHeightOfApertures="+r.getParametersCalculatedFireLoad().getReducedHeightOfApertures()+"," +
                            "SET generalSquareOfApertures="+r.getParametersCalculatedFireLoad().getGeneralSquareOfApertures()+"," +
                            "SET ventilationParameter="+ r.getParametersCalculatedFireLoad().getVentilationParameter()+"," +
                            "SET coefficientK="+r.getParametersCalculatedFireLoad().getCoefficientK()+"," +
                            "SET coefficientA="+r.getParametersCalculatedFireLoad().getCoefficientA()+"," +
                            "SET coefficientB="+r.getParametersCalculatedFireLoad().getCoefficientB()+"," +
                            "SET coefficientS="+r.getParametersCalculatedFireLoad().getCoefficientS()+"," +
                            "SET estimatedFireLoad="+r.getParametersCalculatedFireLoad().getEstimatedFireLoad()+"," +
                            "SET proemnostOfRoom="+r.getDetermineTheTypeOfFire().getProemnostOfRoom()+"," +
                            "SET averageAmountOfCombustionAir="+r.getDetermineTheTypeOfFire().getAverageAmountOfCombustionAir()+"," +
                            "SET specificCriticalAmountOfFireLoad="+r.getDetermineTheTypeOfFire().getSpecificCriticalAmountOfFireLoad()+"," +
                            "SET specificValueOfFireLoad="+r.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad()+"," +
                            "SET PRN="+r.getDetermineTheTypeOfFire().isPRN()+"," +
                            "SET maximumMeanBulkTemperature="+ r.getIntegratedThermalAndTechnicalParameters().getMaximumMeanBulkTemperature()+"," +
                            "SET durationOfFireSurround="+r.getIntegratedThermalAndTechnicalParameters().getDurationOfFireSurround()+"," +
                            "SET timeReachMaximumMeanBulkTemperature="+r.getIntegratedThermalAndTechnicalParameters().getTimeReachMaximumMeanBulkTemperature()+"," +
                            "SET maximumAverageTemperatureOfWallSurface="+r.getIntegratedThermalAndTechnicalParameters().getMaximumAverageTemperatureOfWallSurface()+"," +
                            "SET timeToReachMaximumTemperatureOfWallSurface="+r.getIntegratedThermalAndTechnicalParameters().getTimeToReachMaximumTemperatureOfWallSurface()+"," +
                            "SET averageMaximumTemperatureOfSlab="+r.getIntegratedThermalAndTechnicalParameters().getAverageMaximumTemperatureOfSlab()+"," +
                            "SET timeToReachMaximumTemperatureOfSlabSurface="+r.getIntegratedThermalAndTechnicalParameters().getTimeToReachMaximumTemperatureOfSlabSurface()+"," +
                            "SET fk.id.building="+id_building+" "+
                            "WHERE id.room="+id_room+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void UpdToCoefficientsForRoom(Integer id_room,Double s1,Double s4,Double s7,Double s8,Double s9,Double s10,Integer id_coefficientsforroom){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "UPDATE coefficientsforroom SET fk.id.room="+id_room+", SET s1="+s1+",SET s4="+s4+"," +
                            "SET s7="+s7+",SET s8="+s8+",SET s9="+s9+",SET s10="+s10+") "+
                            "WHERE id.coefficientsforroom="+id_coefficientsforroom+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void UpdToCoefficientsForRoom(Integer id_room, List<Double> s,Integer id_coefficientsforroom){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "UPDATE coefficientsforroom SET fk.id.room="+id_room+", SET s1="+s.get(0)+",SET s4="+s.get(1)+"," +
                            "SET s7="+s.get(2)+",SET s8="+s.get(3)+",SET s9="+s.get(4)+",SET s10="+s.get(5)+") "+
                            "WHERE id.coefficientsforroom="+id_coefficientsforroom+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void UpdToCoefficientsForBuilding(Integer id_building,Double s2,Double s3,Double s5,Double s6,Integer id_coefficientSForBuilding){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "UPDATE coefficientsforbuilding SET fk.id.building="+id_building+", SET s2="+s2+",SET s3="+s3+"," +
                            "SET s5="+s5+",SET s6="+s6+" "+
                            "WHERE id.coefficientSForBuilding="+id_coefficientSForBuilding+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void UpdToCoefficientsForBuilding(Integer id_building, List<Double> s,Integer id_coefficientSForBuilding){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            statement.executeUpdate(
                    "UPDATE coefficientsforbuilding SET fk.id.building="+id_building+", SET s2="+s.get(0)+",SET s3="+s.get(1)+"," +
                            "SET s5="+s.get(2)+",SET s6="+s.get(3)+" "+
                            "WHERE id.coefficientSForBuilding="+id_coefficientSForBuilding+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void UpdToChangesInMeanBulkTemperature(Integer id_room, List<Double> t,Integer id_changesinmeanbulktemperature){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            StringBuilder sb=new StringBuilder();
            for (int i=0;i<t.size();i++){
                StringBuilder sb1=new StringBuilder(",SET t"+i+"="+t.get(i));
                sb.append(sb1);
            }
            statement.executeUpdate(
                    "UPDATE changesinmeanbulktemperature SET fk.id.room="+id_room+""+sb+" "+
                            "WHERE id.changesinmeanbulktemperature="+id_changesinmeanbulktemperature+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void UpdToChangeInAverageTemperatureOfWalls(Integer id_room, List<Double> t,Integer id_changeinaveragetemperatureofwalls){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            StringBuilder sb=new StringBuilder();
            for (int i=0;i<t.size();i++){
                StringBuilder sb1=new StringBuilder(",SET t"+i+"="+t.get(i));
                sb.append(sb1);
            }
            statement.executeUpdate(
                    "UPDATE changesinmeanbulktemperature SET fk.id.room="+id_room+""+sb+" "+
                            "WHERE id.changeinaveragetemperatureofwalls="+id_changeinaveragetemperatureofwalls+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void UpdToChangeInAverageTemperatureOfSlab(Integer id_room, List<Double> t,Integer id_changeinaveragetemperatureofslab){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            StringBuilder sb=new StringBuilder();
            for (int i=0;i<t.size();i++){
                StringBuilder sb1=new StringBuilder(",SET t"+i+"="+t.get(i));
                sb.append(sb1);
            }
            statement.executeUpdate(
                    "UPDATE changesinmeanbulktemperature SET fk.id.room="+id_room+""+sb+" "+
                            "WHERE id.changeinaveragetemperatureofslab="+id_changeinaveragetemperatureofslab+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void UpdToBuilding(String nameOfBuilding, Double selectedTemperatureOfRegion,
                                     Double specifyingCoefficientS5, Integer id_user, Integer id_allbuildings,Integer id_building){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            statement.executeUpdate(
                    "UPDATE building SET nameOfBuilding="+nameOfBuilding+",SET selectedTemperatureOfRegion="+selectedTemperatureOfRegion+"," +
                            "SET specifyingCoefficientS5="+specifyingCoefficientS5+",SET fk.id.user="+id_user+"," +
                            "SET fk.id.allbuildings="+id_allbuildings+" "+
                            "WHERE id.building="+id_building+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void UpdToBuilding(Building build, Integer id_user, Integer id_allbuildings,Integer id_building){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            statement.executeUpdate(
                    "UPDATE building SET nameOfBuilding="+build.getNameOfBuilding()+"," +
                            "SET selectedTemperatureOfRegion="+build.getSelectedTemperatureOfRegion()+"," +
                            "SET specifyingCoefficientS5="+build.getSpecifyingCoefficientS5()+",SET fk.id.user="+id_user+"," +
                            "SET fk.id.allbuildings="+id_allbuildings+" "+
                            "WHERE id.building="+id_building+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void UpdToAperure(List<Aperture> ap, Integer id_room,Integer id_aperture){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            for (Aperture temp:ap)
                statement.executeUpdate(
                        "UPDATE aperture SET typeOfAperture="+temp.getTypeOfAperture()+", SET width="+temp.getWidth()+"," +
                                "SET height="+temp.getHeight()+",SET count="+temp.getCount()+"," +
                                "SET squareOfAperture="+temp.getSquareOfAperture()+",SET fk.id.room="+id_room+" "+
                                "WHERE id.aperture="+id_aperture+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void UpdToAllBuildings(Integer id_allbuildings){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            GregorianCalendar time = new GregorianCalendar();
            time.setTimeInMillis(System.currentTimeMillis());
            statement.executeUpdate(
                    "UPDATE aperture SET dateofbuilding="+time.get(time.HOUR_OF_DAY)+":"+time.get(time.MINUTE)+" "+time.get(time.DATE)+"-"+(time.get(time.MONTH)+1)+"-"+time.get(time.YEAR)+" "+
                            "WHERE id.allbuildings="+id_allbuildings+";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
