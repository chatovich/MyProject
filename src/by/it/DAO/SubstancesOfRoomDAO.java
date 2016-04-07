package by.it.DAO;

import by.it.generate.SubstancesOfRoom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 06.04.2016.
 */
class SubstancesOfRoomDAO extends DAO implements InterfaceDAO<SubstancesOfRoom>  {
    @Override
    public List<SubstancesOfRoom> getAll(String WHERE) {
        List<SubstancesOfRoom> substances = new ArrayList<>();
        String sql = "SELECT * FROM substancesOfRoom " + WHERE + " ;";
        try (
                Statement statement = getDAO().getConnection().createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                SubstancesOfRoom substance = new SubstancesOfRoom();
                substance.setFkIdRoom((short) rs.getInt("fk.id.room"));
                substance.setFkIdSubstance((short)rs.getInt("fk.id.substance"));
                substance.setWeight(rs.getDouble("weight"));
                FlammableSubstanceDAO f=new FlammableSubstanceDAO();
                substance.setFlammableSubstance(f.read(substance.getFkIdSubstance()));
                substances.add(substance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            closeDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return substances;
    }

    @Override
    public SubstancesOfRoom read(int id) {
        List<SubstancesOfRoom> substances = getAll("WHERE id.substancesOfRoom=" + id + " LIMIT 0,1");
        if (substances.size() > 0) {
            return substances.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(SubstancesOfRoom substance) throws SQLException {
        String sql = String.format(
                "insert INTO substancesOfRoom(`fk.id.room`,`fk.id.substance`,`weight`)" +
                        " values('%s','%s','%s');",
                substance.getFkIdRoom(),substance.getFkIdSubstance(),substance.getWeight()
        );
        FlammableSubstanceDAO fs=new FlammableSubstanceDAO();
        fs.create(substance.getFlammableSubstance());

        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;

    }
    @Override
    public boolean update(SubstancesOfRoom substance) throws SQLException  {
        String sql = String.format(
                "UPDATE `substancesOfRoom` SET `fk.id.room` = '%s', `fk.id.substance` = '%s', `weight` = '%s' " +
                        " WHERE `id.substancesOfRoom` = %d",
                substance.getFkIdRoom(), substance.getFkIdSubstance(), substance.getWeight(),substance.getIdSubstancesOfRoom()
        );
        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;
    }
    @Override
    public boolean delete(SubstancesOfRoom substance) throws SQLException  {
        String sql = String.format(
                "DELETE FROM `substancesOfRoom` WHERE `id.substancesOfRoom` = %d;", substance.getIdSubstancesOfRoom()
        );
        FlammableSubstanceDAO fs=new FlammableSubstanceDAO();
        fs.delete(substance.getFlammableSubstance());
        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;
    }


}
