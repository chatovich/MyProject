package by.it.Utils.JD03_01.OtherSqlMethods;

import by.it.Utils.JD03_01.CN;
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
public class Insert {
    public static void addToUsers(String login, String password, String email, Boolean admin){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

                statement.executeUpdate(
                    "INSERT INTO users (login, password, email,admin) "+
                            "VALUES ("+login+","+password+","+email+","+admin+");");
            }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void addToSubstancesOfRoom(Integer id_substance, Integer id_room, Double weight){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "INSERT INTO substancesofroom (fk.id.substance, fk.id.room, weight) "+
                            "VALUES ("+id_substance+","+id_room+","+weight+");");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void addToFlammableSubstance(String name, Double amountOfCombustionAir, Double combustionHeat, Double averageSpeedBurnout){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "INSERT INTO flammablesubstance (name, amountOfCombustionAir,combustionHeat,averageSpeedBurnout) "+
                            "VALUES ("+name+","+amountOfCombustionAir+","+combustionHeat+","+averageSpeedBurnout+");");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void addToRoom(String position, String name, Double square, Double height, Double perimeter,
                                 Double volume, Double squareOfConstruction, Double specificFireLoad, Double reducedHeightOfApertures,
                                 Double generalSquareOfApertures, Double ventilationParameter, Double coefficientK, Double coefficientA,
                                 Double coefficientB, Double coefficientS, Double estimatedFireLoad, Double proemnostOfRoom,
                                 Double averageAmountOfCombustionAir, Double specificCriticalAmountOfFireLoad,
                                 Double specificValueOfFireLoad, Boolean PRN, Double maximumMeanBulkTemperature,
                                 Double durationOfFireSurround, Double timeReachMaximumMeanBulkTemperature,
                                 Double maximumAverageTemperatureOfWallSurface, Double timeToReachMaximumTemperatureOfWallSurface,
                                 Double averageMaximumTemperatureOfSlab, Double timeToReachMaximumTemperatureOfSlabSurface){
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
    }
    public static void addToRoom(Room r, Integer id_building){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "INSERT INTO room (position, name, square,height,perimeter,volume,squareOfConstruction,specificFireLoad," +
                            "reducedHeightOfApertures,generalSquareOfApertures,ventilationParameter,coefficientK,coefficientA," +
                            "coefficientB,coefficientS,estimatedFireLoad,proemnostOfRoom,averageAmountOfCombustionAir," +
                            "specificCriticalAmountOfFireLoad,specificValueOfFireLoad,PRN,maximumMeanBulkTemperature," +
                            "durationOfFireSurround,timeReachMaximumMeanBulkTemperature,maximumAverageTemperatureOfWallSurface," +
                            "timeToReachMaximumTemperatureOfWallSurface,averageMaximumTemperatureOfSlab," +
                            "timeToReachMaximumTemperatureOfSlabSurface,fk.id.building) "+
                            "VALUES ("+r.getCommonParameters().getPosition()+","+r.getCommonParameters().getName()+
                            ","+r.getCommonParameters().getSquare()+","+r.getCommonParameters().getHeight()+","+
                            r.getCommonParameters().getPerimeter()+","+r.getCommonParameters().getVolume()+","+
                            r.getCommonParameters().getSquareOfConstruction()+","+r.getParametersCalculatedFireLoad().getSpecificFireLoad()+
                            ","+r.getParametersCalculatedFireLoad().getReducedHeightOfApertures()+
                            ","+r.getParametersCalculatedFireLoad().getGeneralSquareOfApertures()+","+
                            r.getParametersCalculatedFireLoad().getVentilationParameter()+","+r.getParametersCalculatedFireLoad().getCoefficientK()+","+
                            r.getParametersCalculatedFireLoad().getCoefficientA()+","+r.getParametersCalculatedFireLoad().getCoefficientB()+","+
                            r.getParametersCalculatedFireLoad().getCoefficientS()+","+r.getParametersCalculatedFireLoad().getEstimatedFireLoad()+","+
                            r.getDetermineTheTypeOfFire().getProemnostOfRoom()+","+r.getDetermineTheTypeOfFire().getAverageAmountOfCombustionAir()+","+
                            r.getDetermineTheTypeOfFire().getSpecificCriticalAmountOfFireLoad()+
                            ","+r.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad()+","+r.getDetermineTheTypeOfFire().isPRN()+","+
                            r.getIntegratedThermalAndTechnicalParameters().getMaximumMeanBulkTemperature()+","+
                            r.getIntegratedThermalAndTechnicalParameters().getDurationOfFireSurround()+","+
                            r.getIntegratedThermalAndTechnicalParameters().getTimeReachMaximumMeanBulkTemperature()+
                            ","+r.getIntegratedThermalAndTechnicalParameters().getMaximumAverageTemperatureOfWallSurface()+","+
                            r.getIntegratedThermalAndTechnicalParameters().getTimeToReachMaximumTemperatureOfWallSurface()+","+
                            r.getIntegratedThermalAndTechnicalParameters().getAverageMaximumTemperatureOfSlab()+","+
                            r.getIntegratedThermalAndTechnicalParameters().getTimeToReachMaximumTemperatureOfSlabSurface()+","+id_building+");");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void addToCoefficientsForRoom(Integer id_room,Double s1,Double s4,Double s7,Double s8,Double s9,Double s10){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "INSERT INTO coefficientsforroom (fk.id.room, s1,s4,s7,s8,s9,s10) "+
                            "VALUES ("+id_room+","+s1+","+s4+","+s7+","+s8+","+s9+","+s10+");");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void addToCoefficientsForRoom(Integer id_room, List<Double> s){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "INSERT INTO coefficientsforroom (fk.id.room, s1,s4,s7,s8,s9,s10) "+
                            "VALUES ("+id_room+","+s.get(0)+","+s.get(1)+","+s.get(2)+","+s.get(3)+","+s.get(4)+","+s.get(5)+");");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void addToCoefficientsForBuilding(Integer id_building,Double s2,Double s3,Double s5,Double s6){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "INSERT INTO coefficientsforbuilding (fk.id.building, s2,s3,s5,s6) "+
                            "VALUES ("+id_building+","+s2+","+s3+","+s5+","+s6+");");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void addToCoefficientsForBuilding(Integer id_building, List<Double> s){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            statement.executeUpdate(
                    "INSERT INTO coefficientsforbuilding (fk.id.building, s2,s3,s5,s6) "+
                            "VALUES ("+id_building+","+s.get(0)+","+s.get(1)+","+s.get(2)+","+s.get(3)+");");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void addToChangesInMeanBulkTemperature(Integer id_room, List<Double> t){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            StringBuilder sb=new StringBuilder();
            for (int i=0;i<t.size();i++){
                StringBuilder sb1=new StringBuilder(",t"+i);
                sb.append(sb1);
            }
            StringBuilder sb1=new StringBuilder();
            for (Double temp:t){
                StringBuilder sb2=new StringBuilder(","+temp);
                sb1.append(sb2);
            }
            statement.executeUpdate(
                    "INSERT INTO changesinmeanbulktemperature (fk.id.room"+sb+") "+
                            "VALUES ("+id_room+sb1+");");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void addToChangeInAverageTemperatureOfWalls(Integer id_room, List<Double> t){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            StringBuilder sb=new StringBuilder();
            for (int i=0;i<t.size();i++){
                StringBuilder sb1=new StringBuilder(",t"+i);
                sb.append(sb1);
            }
            StringBuilder sb1=new StringBuilder();
            for (Double temp:t){
                StringBuilder sb2=new StringBuilder(","+temp);
                sb1.append(sb2);
            }
            statement.executeUpdate(
                    "INSERT INTO changeinaveragetemperatureofwalls (fk.id.room"+sb+") "+
                            "VALUES ("+id_room+sb1+");");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void addToChangeInAverageTemperatureOfSlab(Integer id_room, List<Double> t){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            StringBuilder sb=new StringBuilder();
            for (int i=0;i<t.size();i++){
                StringBuilder sb1=new StringBuilder(",t"+i);
                sb.append(sb1);
            }
            StringBuilder sb1=new StringBuilder();
            for (Double temp:t){
                StringBuilder sb2=new StringBuilder(","+temp);
                sb1.append(sb2);
            }
            statement.executeUpdate(
                    "INSERT INTO changeinaveragetemperatureofslab (fk.id.room"+sb+") "+
                            "VALUES ("+id_room+sb1+");");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void addToBuilding(String nameOfBuilding, Double selectedTemperatureOfRegion,
                                     Double specifyingCoefficientS5, Integer id_user, Integer id_allbuildings){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            statement.executeUpdate(
                    "INSERT INTO building (nameOfBuilding, selectedTemperatureOfRegion," +
                            "specifyingCoefficientS5,fk.id.user,fk.id.allbuildings) "+
                            "VALUES ("+nameOfBuilding+","+selectedTemperatureOfRegion+","+
                            specifyingCoefficientS5+","+id_user+","+id_allbuildings+");");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void addToBuilding(Building build, Integer id_user, Integer id_allbuildings){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            statement.executeUpdate(
                    "INSERT INTO building (nameOfBuilding, selectedTemperatureOfRegion," +
                            "specifyingCoefficientS5,fk.id.user,fk.id.allbuildings) "+
                            "VALUES ("+build.getNameOfBuilding()+","+build.getSelectedTemperatureOfRegion()+","+
                            build.getSpecifyingCoefficientS5()+","+id_user+","+id_allbuildings+");");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void addToAperure(List<Aperture> ap, Integer id_room){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            for (Aperture temp:ap)
            statement.executeUpdate(
                    "INSERT INTO aperture (typeOfAperture, width," +
                            "height,count,squareOfAperture,fk.id.room) "+
                            "VALUES ("+temp.getTypeOfAperture()+","+temp.getWidth()+","+
                            temp.getHeight()+","+temp.getCount()+","+temp.getSquareOfAperture()+","+id_room+");");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void addToAllBuildings(){
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            GregorianCalendar time = new GregorianCalendar();
            time.setTimeInMillis(System.currentTimeMillis());
                statement.executeUpdate(
                        "INSERT INTO aperture (dateofbuilding) "+
                                "VALUES ("+time.get(time.HOUR_OF_DAY)+":"+time.get(time.MINUTE)+" "+time.get(time.DATE)+"-"+(time.get(time.MONTH)+1)+"-"+time.get(time.YEAR)+");");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
