package by.it.DAO;

import by.it.generate.ChangeInTemperatureOfWalls;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 06.04.2016.
 */
class ChangeWallsTDAO extends DAO implements InterfaceDAO<ChangeInTemperatureOfWalls> {
    @Override
    public List<ChangeInTemperatureOfWalls> getAll(String WHERE) {
        List<ChangeInTemperatureOfWalls> changes = new ArrayList<>();
        String sql = "SELECT * FROM changeInTemperatureOfWalls " + WHERE + " ;";
        try (
                Statement statement = getDAO().getConnection().createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                ChangeInTemperatureOfWalls ch = new ChangeInTemperatureOfWalls();
                ch.setIdChangeInTemperatureOfWalls((short) rs.getInt("id.changeInTemperatureOfWalls"));
                ch.setFkIdRoom((short) rs.getInt("id.fk.room"));
                for (int i = 0; i < 121; i++)
                    ch.getChanges().add(rs.getDouble("changes" + i));
                changes.add(ch);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            closeDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return changes;
    }

    @Override
    public ChangeInTemperatureOfWalls read(int id) {
        List<ChangeInTemperatureOfWalls> changes = getAll("WHERE id.changeInTemperatureOfWalls=" + id + " LIMIT 0,1");
        if (changes.size() > 0) {
            return changes.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(ChangeInTemperatureOfWalls ch) throws SQLException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.getChanges().size(); i++) {
            StringBuilder sb1 = new StringBuilder(",`changes" + i + "`");
            sb.append(sb1);
        }
        StringBuilder sb1 = new StringBuilder();
        for (Double temp : ch.getChanges()) {
            StringBuilder sb2 = new StringBuilder(",'" + temp + "'");
            sb1.append(sb2);
        }
        String sql =
                "INSERT INTO changeInTemperatureOfWalls (`fk.id.room`" + sb + ") " +
                        "VALUES ('" + ch.getFkIdRoom() + "'" + sb1 + ");";

        getDAO();
        Boolean check = (0 < executeUpdate(sql));
        closeDAO();
        return check;

    }

    @Override
    public boolean update(ChangeInTemperatureOfWalls ch) throws SQLException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.getChanges().size(); i++) {
            StringBuilder sb1 = new StringBuilder(",SET t" + i + "=" + ch.getChanges().get(i));
            sb.append(sb1);
        }
        String sql = "UPDATE changeInTemperatureOfWalls SET fk.id.room=" + ch.getFkIdRoom() + "" + sb + " " +
                "WHERE id.changeInTemperatureOfWalls=" + ch.getIdChangeInTemperatureOfWalls() + ";";
        getDAO();
        Boolean check = (0 < executeUpdate(sql));
        closeDAO();
        return check;
    }

    @Override
    public boolean delete(ChangeInTemperatureOfWalls ch) throws SQLException {
        String sql = "DELETE FROM changeInTemperatureOfWalls " +
                "WHERE id.changeInTemperatureOfWalls=" + ch.getIdChangeInTemperatureOfWalls() + ";";

        getDAO();
        Boolean check = (0 < executeUpdate(sql));
        closeDAO();
        return check;
    }
}