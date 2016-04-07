package by.it.DAO;

import by.it.generate.Building;
import by.it.generate.Room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 07.04.2016.
 */
public class BuildingDAO extends DAO implements InterfaceDAO<Building>  {
    @Override
    public List<Building> getAll(String WHERE) {
        List<Building> buildings = new ArrayList<>();
        String sql = "SELECT * FROM building " + WHERE + " ;";
        try (
                Statement statement = getDAO().getConnection().createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Building building = new Building();
                building.setIdBuilding((short) rs.getInt("id.building"));
                building.setFkIdUser((short)rs.getInt("fk.id.user"));
                building.setNameOfBuilding(rs.getString("nameOfBuilding"));
                building.setSelectedTemperatureOfRegion(rs.getDouble("selectedTemperatureOfRegion"));
                building.setSpecifyingCoefficientS5(rs.getDouble("specifyingCoefficientS5"));
                building.setDateOfBuilding(rs.getString("dateOfBuilding"));
                //заодно получим коэффициенты
                CoefficientSForBuildDAO cf=new CoefficientSForBuildDAO();
                building.setCoefficientSForBuild(cf.getAll("fk.id.building="+building.getIdBuilding()).get(0));
                //также получим и помещение
                RoomDAO r=new RoomDAO();
                List<Room> rooms=r.getAll("fk.id.building="+building.getIdBuilding());
                building.getRoom().addAll(rooms);

                buildings.add(building);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            closeDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buildings;
    }

    @Override
    public Building read(int id) {
        List<Building> apertures = getAll("WHERE id.building=" + id + " LIMIT 0,1");
        if (apertures.size() > 0) {
            return apertures.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(Building building) throws SQLException {
        String sql = String.format(
                "insert INTO building(`fk.id.user`,`nameOfBuilding`,`selectedTemperatureOfRegion`," +
                        "`specifyingCoefficientS5`,`dateOfBuilding`)" +
                        " values('%s','%s','%s','%s','%s');",
                building.getFkIdUser(),building.getNameOfBuilding(),building.getSelectedTemperatureOfRegion(),
                building.getSpecifyingCoefficientS5(),"созд.: "+building.getDateOfBuilding()

        );
        //заодно вставим коэффициенты
        CoefficientSForBuildDAO cf=new CoefficientSForBuildDAO();
        cf.create(building.getCoefficientSForBuild());
        //также вставим и помещения
        RoomDAO r=new RoomDAO();
        List<Room> rooms=building.getRoom();
        for (Room temp:rooms){
            r.create(temp);
        }
        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();

        return check;

    }
    @Override
    public boolean update(Building building) throws SQLException  {
        String sql = String.format(
                "UPDATE `building` SET `fk.id.user` = '%s', `nameOfBuilding` = '%s', `selectedTemperatureOfRegion` = '%s', " +
                        "`specifyingCoefficientS5`='%s', `dateOfBuilding`='%s' WHERE `id.building` = %d",
                building.getFkIdUser(),building.getNameOfBuilding(),building.getSelectedTemperatureOfRegion(),
                building.getSpecifyingCoefficientS5(),"изм.: "+building.getDateOfBuilding(),building.getIdBuilding()
        );
        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;
    }
    @Override
    public boolean delete(Building building) throws SQLException  {
        String sql = String.format(
                "DELETE FROM `building` WHERE `id.building` = %d;", building.getIdBuilding()
        );
        //заодно удалим коэффициенты
        CoefficientSForBuildDAO cf=new CoefficientSForBuildDAO();
        cf.delete(building.getCoefficientSForBuild());
        //также удалим и помещения
        RoomDAO r=new RoomDAO();
        List<Room> rooms=r.getAll("fk.id.building="+building.getIdBuilding());
        for (Room temp:rooms){
            r.delete(temp);
        }

        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;
    }
}
