package by.it.DAO;

import by.it.generate.FlammableSubstance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 07.04.2016.
 */
class FlammableSubstanceDAO extends DAO implements InterfaceDAO<FlammableSubstance>  {
    @Override
    public List<FlammableSubstance> getAll(String WHERE) {
        List<FlammableSubstance> substances = new ArrayList<>();
        String sql = "SELECT * FROM flammableSubstance " + WHERE + " ;";
        try (
                Statement statement = getDAO().getConnection().createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                FlammableSubstance substance = new FlammableSubstance();
                substance.setIdSubstance((short) rs.getInt("id.substance"));
                substance.setNameOfSubstance(rs.getString("nameOfSubstance"));
                substance.setAmountOfCombustionAir(rs.getDouble("amountOfCombustionAir"));
                substance.setAverageSpeedBurnout(rs.getDouble("averageSpeedBurnout"));
                substance.setCombustionHeat(rs.getDouble("combustionHeat"));
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
    public FlammableSubstance read(int id) {
        List<FlammableSubstance> substances = getAll("WHERE id.substance=" + id + " LIMIT 0,1");
        if (substances.size() > 0) {
            return substances.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(FlammableSubstance substance) throws SQLException {
        String sql = String.format(
                "insert INTO flammableSubstance(`nameOfSubstance`,`amountOfCombustionAir`,`averageSpeedBurnout`,`combustionHeat`)" +
                        " values('%s','%s','%s','%s');",
                substance.getNameOfSubstance(), substance.getAmountOfCombustionAir(), substance.getAverageSpeedBurnout(),
                substance.getCombustionHeat()
        );
        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;

    }
    @Override
    public boolean update(FlammableSubstance substance) throws SQLException  {
        String sql = String.format(
                "UPDATE `flammableSubstance` SET `nameOfSubstance` = '%s', `amountOfCombustionAir` = '%s', " +
                        "`averageSpeedBurnout` = '%s',`combustionHeat`='%s'",
                substance.getNameOfSubstance(),substance.getAmountOfCombustionAir(),substance.getAverageSpeedBurnout(),
                substance.getCombustionHeat()
        );
        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;
    }
    @Override
    public boolean delete(FlammableSubstance substance) throws SQLException  {
        String sql = String.format(
                "DELETE FROM `flammableSubstance` WHERE `id.substance` = %d;", substance.getIdSubstance()
        );
        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;
    }
}
