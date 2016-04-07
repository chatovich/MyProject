package by.it.DAO;

import by.it.generate.CoefficientSForBuild;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 06.04.2016.
 */
public class CoefficientSForBuildDAO extends DAO implements InterfaceDAO<CoefficientSForBuild>  {
    @Override
    public List<CoefficientSForBuild> getAll(String WHERE) {
        List<CoefficientSForBuild> changes = new ArrayList<>();
        String sql = "SELECT * FROM coefficientSForBuild " + WHERE + " ;";
        try (
                Statement statement = getDAO().getConnection().createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                CoefficientSForBuild ch = new CoefficientSForBuild();
                ch.setIdCoefficientSForBuild((short) rs.getInt("id.coefficientSForBuilding"));
                ch.setFkIdBuilding((short)rs.getInt("id.fk.boom"));

                ch.getS().add(rs.getDouble("s2"));
                ch.getS().add(rs.getDouble("s3"));
                ch.getS().add(rs.getDouble("s5"));
                ch.getS().add(rs.getDouble("s6"));

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
    public CoefficientSForBuild read(int id) {
        List<CoefficientSForBuild> changes = getAll("WHERE id.coefficientSForBuilding=" + id + " LIMIT 0,1");
        if (changes.size() > 0) {
            return changes.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(CoefficientSForBuild ch) throws SQLException {

        StringBuilder sb=new StringBuilder(",`s2`,`s3`,`s5`,`s6`");

        StringBuilder sb1=new StringBuilder();
        for (Double temp:ch.getS()){
            StringBuilder sb2=new StringBuilder(",'"+temp+"'");
            sb1.append(sb2);
        }
        String sql =
                "INSERT INTO coefficientSForBuilding (`fk.id.Building`"+sb+") "+
                        "VALUES ('"+ch.getFkIdBuilding()+"'"+sb1+");";

        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;

    }
    @Override
    public boolean update(CoefficientSForBuild ch) throws SQLException  {

        StringBuilder sb=new StringBuilder(",SET s2="+ch.getS().get(0)+",SET s3="+ch.getS().get(1)+",SET s5="+ch.getS().get(2)
            +",SET s6="+ch.getS().get(3));

        String sql = "UPDATE coefficientSForBuilding SET fk.id.building="+ch.getFkIdBuilding()+""+sb+" "+
                "WHERE id.coefficientSForBuilding="+ch.getIdCoefficientSForBuild()+";";
        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;
    }
    @Override
    public boolean delete(CoefficientSForBuild ch) throws SQLException  {
        String sql = "DELETE FROM coefficientSForBuilding "+
                "WHERE id.coefficientSForBuilding="+ch.getIdCoefficientSForBuild()+";";

        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;
    }
}
