package by.it.DAO;

import by.it.generate.Aperture;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class ApertureDAO extends DAO implements InterfaceDAO<Aperture> {
    @Override
    public List<Aperture> getAll(String WHERE) {
        List<Aperture> apertures = new ArrayList<>();
        String sql = "SELECT * FROM aperture " + WHERE + " ;";
        try (
                Statement statement = getDAO().getConnection().createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Aperture aperture = new Aperture();
                aperture.setIdAperture((short) rs.getInt("id.aperture"));
                aperture.setFkIdRoom((short)rs.getInt("id.fk.room"));
                aperture.setTypeOfAperture(rs.getString("typeOfAperture"));
                aperture.setHeight(rs.getDouble("height"));
                aperture.setWidth(rs.getDouble("width"));
                aperture.setSquareOfAperture(rs.getDouble("squareOfAperture"));
                aperture.setCount((short) rs.getInt("count"));
                apertures.add(aperture);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            closeDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return apertures;
    }

    @Override
    public Aperture read(int id) {
        List<Aperture> apertures = getAll("WHERE id.aperture=" + id + " LIMIT 0,1");
        if (apertures.size() > 0) {
            return apertures.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(Aperture aperture) throws SQLException {
        String sql = String.format(
                "insert INTO aperture(`typeOfAperture`,`height`,`width`,`squareOfAperture`,`count`,`id.fk.room`)" +
                        " values('%s','%s','%s','%s','%d','%s');",
                aperture.getTypeOfAperture(), aperture.getHeight(), aperture.getWidth(),aperture.getSquareOfAperture(),
                aperture.getCount(),aperture.getFkIdRoom()
        );
        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;

    }
    @Override
    public boolean update(Aperture aperture) throws SQLException  {
        String sql = String.format(
                "UPDATE `aperture` SET `typeOfAperture` = '%s', `height` = '%s', `width` = '%s', " +
                        "`squareOfAperture`='%s', `count`='%s', `id.fk.room`='%s' WHERE `id.aperture` = %d",
                aperture.getTypeOfAperture(), aperture.getHeight(), aperture.getWidth(), aperture.getSquareOfAperture(),
                aperture.getCount(),aperture.getFkIdRoom(),aperture.getIdAperture()
        );
        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;
    }
    @Override
    public boolean delete(Aperture aperture) throws SQLException  {
        String sql = String.format(
                "DELETE FROM `aperture` WHERE `id.user` = %d;", aperture.getIdAperture()
        );
        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;
    }


}


