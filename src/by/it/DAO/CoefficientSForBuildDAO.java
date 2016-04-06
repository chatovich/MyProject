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
                ch.setIdCoefficientSForBuild((short) rs.getInt("id.coefficientSForBuild"));
                ch.setFkIdBuilding((short)rs.getInt("id.fk.boom"));
                for (int i=0;i<4;i++)
                    ch.getS().add(rs.getDouble("s"+i));
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
        List<CoefficientSForBuild> changes = getAll("WHERE id.coefficientSForBuild=" + id + " LIMIT 0,1");
        if (changes.size() > 0) {
            return changes.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(CoefficientSForBuild ch) throws SQLException {
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<ch.getS().size();i++){
            StringBuilder sb1=new StringBuilder(",`s"+i+"`");
            sb.append(sb1);
        }
        StringBuilder sb1=new StringBuilder();
        for (Double temp:ch.getS()){
            StringBuilder sb2=new StringBuilder(",'"+temp+"'");
            sb1.append(sb2);
        }
        String sql =
                "INSERT INTO coefficientSForBuild (`fk.id.boom`"+sb+") "+
                        "VALUES ('"+ch.getFkIdBuilding()+"'"+sb1+");";

        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;

    }
    @Override
    public boolean update(CoefficientSForBuild ch) throws SQLException  {
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<ch.getS().size();i++){
            StringBuilder sb1=new StringBuilder(",SET s"+i+"="+ch.getS().get(i));
            sb.append(sb1);
        }
        String sql = "UPDATE coefficientSForBuild SET fk.id.build="+ch.getFkIdBuilding()+""+sb+" "+
                "WHERE id.coefficientSForBuild="+ch.getIdCoefficientSForBuild()+";";
        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;
    }
    @Override
    public boolean delete(CoefficientSForBuild ch) throws SQLException  {
        String sql = "DELETE FROM coefficientSForBuild "+
                "WHERE id.coefficientSForBuild="+ch.getIdCoefficientSForBuild()+";";

        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;
    }
}
