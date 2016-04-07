package by.it.DAO;

import by.it.generate.Aperture;
import by.it.generate.ChangeInTemperatureOfWalls;
import by.it.generate.Room;
import by.it.generate.SubstancesOfRoom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class RoomDAO extends DAO implements InterfaceDAO<Room> {
    @Override
    public List<Room> getAll(String WHERE) {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM room " + WHERE + " ;";
        try (
                Statement statement = getDAO().getConnection().createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Room room = new Room();
                room.setIdRoom((short) rs.getInt("id.room"));
                room.getCommonParameters().setPositionOfRoom(rs.getString("positionOfRoom"));
                room.getCommonParameters().setNameOfRoom(rs.getString("nameOfRoom"));
                room.getCommonParameters().setSquare(rs.getDouble("square"));
                room.getCommonParameters().setHeight(rs.getDouble("height"));
                room.getCommonParameters().setPerimeter(rs.getDouble("perimeter"));
                room.getCommonParameters().setSquareOfConstruction(rs.getDouble("squareOfConstruction"));
                room.getParametersCalculatedFireLoad().setSpecificFireLoad(rs.getDouble("specificFireLoad"));
                room.getParametersCalculatedFireLoad().setSpecificFireLoadZVEZDOCHKA(rs.getDouble("specificFireLoadZVEZDOCHKA"));
                room.getParametersCalculatedFireLoad().setReducedHeightOfApertures(rs.getDouble("reducedHeightOfApertures"));
                room.getParametersCalculatedFireLoad().setGeneralSquareOfApertures(rs.getDouble("generalSquareOfApertures"));
                room.getParametersCalculatedFireLoad().setVentilationParameter(rs.getDouble("ventilationParameter"));
                room.getParametersCalculatedFireLoad().setCoefficientK(rs.getDouble("coefficientK"));
                room.getParametersCalculatedFireLoad().setCoefficientA(rs.getDouble("coefficientA"));
                room.getParametersCalculatedFireLoad().setCoefficientB(rs.getDouble("coefficientB"));
                room.getParametersCalculatedFireLoad().setCoefficientS(rs.getDouble("coefficientS"));
                room.getParametersCalculatedFireLoad().setEstimatedFireLoad(rs.getDouble("estimatedFireLoad"));
                room.getDetermineTheTypeOfFire().setProemnostOfRoom(rs.getDouble("proemnostOfRoom"));
                room.getDetermineTheTypeOfFire().setAverageAmountOfCombustionAir(rs.getDouble("averageAmountOfCombustionAir"));
                room.getDetermineTheTypeOfFire().setSpecificCriticalAmountOfFireLoad(rs.getDouble("specificCriticalAmountOfFireLoad"));
                room.getDetermineTheTypeOfFire().setSpecificValueOfFireLoad(rs.getDouble("specificValueOfFireLoad"));
                room.getDetermineTheTypeOfFire().setPRN(rs.getBoolean("PRN"));
                room.getIntegratedThermalAndTechnicalParameters().setMaximumMeanBulkTemperature(rs.getDouble("maximumMeanBulkTemperature"));
                room.getIntegratedThermalAndTechnicalParameters().setDurationOfFireSurround(rs.getDouble("durationOfFireSurround"));
                room.getIntegratedThermalAndTechnicalParameters().setTimeReachMaximumMeanBulkTemperature(rs.getDouble("timeReachMaximumMeanBulkTemperature"));
                room.getIntegratedThermalAndTechnicalParameters().setMaximumAverageTemperatureOfWallSurface(rs.getDouble("maximumAverageTemperatureOfWallSurface"));
                room.getIntegratedThermalAndTechnicalParameters().setTimeToReachMaximumTemperatureOfWallSurface(rs.getDouble("timeToReachMaximumTemperatureOfWallSurface"));
                room.getIntegratedThermalAndTechnicalParameters().setAverageMaximumTemperatureOfSlab(rs.getDouble("averageMaximumTemperatureOfSlab"));
                room.getIntegratedThermalAndTechnicalParameters().setTimeToReachMaximumTemperatureOfSlabSurface(rs.getDouble("timeToReachMaximumTemperatureOfSlabSurface"));
                room.setFkIdBuilding(rs.getShort("fk.id.building"));

                //добавляем и все внутренности
                SubstancesOfRoomDAO s=new SubstancesOfRoomDAO();
                List<SubstancesOfRoom> sr=s.getAll("fk.id.room="+room.getIdRoom());
                room.getSubstancesOfRoom().addAll(sr);

                ApertureDAO a=new ApertureDAO();
                List<Aperture> ap=a.getAll("fk.id.room="+room.getIdRoom());
                room.getAperture().addAll(ap);

                CoefficientSForRoomDAO c=new CoefficientSForRoomDAO();
                room.setCoefficientSForRoom(c.getAll("fk.id.room="+room.getIdRoom()).get(0));

                ChangeMeanBulkTDAO ch=new ChangeMeanBulkTDAO();
                room.setChangeInMeanBulkTemperature(ch.getAll("fk.id.room="+room.getIdRoom()).get(0));

                ChangeWallsTDAO ch1=new ChangeWallsTDAO();
                room.setChangeInTemperatureOfWalls(ch1.getAll("fk.id.room="+room.getIdRoom()).get(0));

                ChangeSlabTDAO ch2=new ChangeSlabTDAO();
                room.setChangeInTemperatureOfSlab(ch2.getAll("fk.id.room="+room.getIdRoom()).get(0));

                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            closeDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    @Override
    public Room read(int id) {
        List<Room> rooms = getAll("WHERE id.room=" + id + " LIMIT 0,1");
        if (rooms.size() > 0) {
            return rooms.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(Room r) throws SQLException {
        String sql = String.format(
                "INSERT INTO room (`positionOfRoom`,`nameOfRoom`,`square`,`height`,`perimeter`,`volume`,`squareOfConstruction`," +
                        "`specificFireLoad`," +"`specificFireLoadZVEZDOCHKA`,"+
                        "`reducedHeightOfApertures`,`generalSquareOfApertures`,`ventilationParameter`,`coefficientK`,`coefficientA`," +
                        "`coefficientB`,`coefficientS`,`estimatedFireLoad`,`proemnostOfRoom`,`averageAmountOfCombustionAir`," +
                        "`specificCriticalAmountOfFireLoad`,`specificValueOfFireLoad`,`PRN`,`maximumMeanBulkTemperature`," +
                        "`durationOfFireSurround`,`timeReachMaximumMeanBulkTemperature`,`maximumAverageTemperatureOfWallSurface`," +
                        "`timeToReachMaximumTemperatureOfWallSurface`,`averageMaximumTemperatureOfSlab`," +
                        "`timeToReachMaximumTemperatureOfSlabSurface`,`fk.id.building`) "+
                        "VALUES ('"+r.getCommonParameters().getPositionOfRoom()+"','"+r.getCommonParameters().getNameOfRoom()+
                        "','"+r.getCommonParameters().getSquare()+"','"+r.getCommonParameters().getHeight()+"','"+
                        r.getCommonParameters().getPerimeter()+"','"+r.getCommonParameters().getVolume()+"','"+
                        r.getCommonParameters().getSquareOfConstruction()+"','"+r.getParametersCalculatedFireLoad().getSpecificFireLoad()+"','"+r.getParametersCalculatedFireLoad().getSpecificFireLoadZVEZDOCHKA()+
                        "','"+r.getParametersCalculatedFireLoad().getReducedHeightOfApertures()+
                        "','"+r.getParametersCalculatedFireLoad().getGeneralSquareOfApertures()+"','"+
                        r.getParametersCalculatedFireLoad().getVentilationParameter()+"','"+r.getParametersCalculatedFireLoad().getCoefficientK()+"','"+
                        r.getParametersCalculatedFireLoad().getCoefficientA()+"','"+r.getParametersCalculatedFireLoad().getCoefficientB()+"','"+
                        r.getParametersCalculatedFireLoad().getCoefficientS()+"','"+r.getParametersCalculatedFireLoad().getEstimatedFireLoad()+"','"+
                        r.getDetermineTheTypeOfFire().getProemnostOfRoom()+"','"+r.getDetermineTheTypeOfFire().getAverageAmountOfCombustionAir()+"','"+
                        r.getDetermineTheTypeOfFire().getSpecificCriticalAmountOfFireLoad()+
                        "','"+r.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad()+"','"+r.getDetermineTheTypeOfFire().isPRN()+"','"+
                        r.getIntegratedThermalAndTechnicalParameters().getMaximumMeanBulkTemperature()+"','"+
                        r.getIntegratedThermalAndTechnicalParameters().getDurationOfFireSurround()+"','"+
                        r.getIntegratedThermalAndTechnicalParameters().getTimeReachMaximumMeanBulkTemperature()+
                        "','"+r.getIntegratedThermalAndTechnicalParameters().getMaximumAverageTemperatureOfWallSurface()+"','"+
                        r.getIntegratedThermalAndTechnicalParameters().getTimeToReachMaximumTemperatureOfWallSurface()+"','"+
                        r.getIntegratedThermalAndTechnicalParameters().getAverageMaximumTemperatureOfSlab()+"','"+
                        r.getIntegratedThermalAndTechnicalParameters().getTimeToReachMaximumTemperatureOfSlabSurface()+"','"+r.getFkIdBuilding()+"');");

        //заодно создадим коэффициенты
        CoefficientSForRoomDAO cf=new CoefficientSForRoomDAO();
        cf.create(r.getCoefficientSForRoom());
        //также создадим и помещения
        ApertureDAO ap=new ApertureDAO();
        List<Aperture> apertures=r.getAperture();
        for (Aperture temp:apertures){
            ap.create(temp);
        }
        //и остальное
        ChangeMeanBulkTDAO ch=new ChangeMeanBulkTDAO();
        ch.create(r.getChangeInMeanBulkTemperature());

        ChangeWallsTDAO ch1=new ChangeWallsTDAO();
        ch1.create(r.getChangeInTemperatureOfWalls());

        ChangeSlabTDAO ch2=new ChangeSlabTDAO();
        ch2.create(r.getChangeInTemperatureOfSlab());


        SubstancesOfRoomDAO s=new SubstancesOfRoomDAO();
        List<SubstancesOfRoom> sr=r.getSubstancesOfRoom();
        for (SubstancesOfRoom temp:sr){
            s.create(temp);
        }

        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;

    }
    @Override
    public boolean update(Room r) throws SQLException  {
        String sql = String.format(
                "UPDATE room SET positionOfRoom="+r.getCommonParameters().getPositionOfRoom()+",SET nameOfRoom="+r.getCommonParameters().getNameOfRoom()+
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
                        "SET fk.id.building="+r.getFkIdBuilding()+" "+
                        "WHERE id.room="+r.getIdRoom()+";");
        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;
    }
    @Override
    public boolean delete(Room r) throws SQLException  {
        String sql ="DELETE FROM users WHERE id.user="+r.getIdRoom()+";";
        //заодно удалим коэффициенты
        CoefficientSForRoomDAO cf=new CoefficientSForRoomDAO();
        cf.delete(r.getCoefficientSForRoom());
        //также удалим и помещения
        ApertureDAO ap=new ApertureDAO();
        List<Aperture> apertures=ap.getAll("fk.id.room="+r.getIdRoom());
        for (Aperture temp:apertures){
            ap.delete(temp);
        }
        //и остального
        ChangeMeanBulkTDAO ch=new ChangeMeanBulkTDAO();
        ch.delete(r.getChangeInMeanBulkTemperature());

        ChangeWallsTDAO ch1=new ChangeWallsTDAO();
        ch1.delete(r.getChangeInTemperatureOfWalls());

        ChangeSlabTDAO ch2=new ChangeSlabTDAO();
        ch2.delete(r.getChangeInTemperatureOfSlab());

        SubstancesOfRoomDAO s=new SubstancesOfRoomDAO();
        List<SubstancesOfRoom> sr=s.getAll("fk.id.room="+r.getIdRoom());
        for (SubstancesOfRoom temp:sr){
            s.delete(temp);
        }

        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;
    }


}

