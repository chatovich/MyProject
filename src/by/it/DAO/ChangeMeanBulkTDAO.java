package by.it.DAO;

import by.it.generate.Aperture;
import by.it.generate.ChangeInMeanBulkTemperature;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class ChangeMeanBulkTDAO extends DAO implements InterfaceDAO<ChangeInMeanBulkTemperature> {
    @Override
    public List<ChangeInMeanBulkTemperature> getAll(String WHERE) {
        List<ChangeInMeanBulkTemperature> changes = new ArrayList<>();
        String sql = "SELECT * FROM changeInMeanBulkTemperature " + WHERE + " ;";
        try (
                Statement statement = getDAO().getConnection().createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                ChangeInMeanBulkTemperature ch = new ChangeInMeanBulkTemperature();
                ch.setIdChangeInMeanBulkTemperature((short) rs.getInt("id.changeInMeanBulkTemperature"));
                ch.setFkIdRoom((short)rs.getInt("id.fk.room"));
                for (int i=0;i<121;i++)
                ch.getChanges().add(rs.getDouble("changes"+i));
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
    public ChangeInMeanBulkTemperature read(int id) {
        List<ChangeInMeanBulkTemperature> changes = getAll("WHERE id.changeInMeanBulkTemperature=" + id + " LIMIT 0,1");
        if (changes.size() > 0) {
            return changes.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(ChangeInMeanBulkTemperature ch) throws SQLException {
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<ch.getChanges().size();i++){
            StringBuilder sb1=new StringBuilder(",`changes"+i+"`");
            sb.append(sb1);
        }
        StringBuilder sb1=new StringBuilder();
        for (Double temp:ch.getChanges()){
            StringBuilder sb2=new StringBuilder(",'"+temp+"'");
            sb1.append(sb2);
        }
        String sql =
                "INSERT INTO changeinmeanbulktemperature (`fk.id.room`"+sb+") "+
                        "VALUES ('"+ch.getFkIdRoom()+"'"+sb1+");";

        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;

    }
    @Override
    public boolean update(ChangeInMeanBulkTemperature ch) throws SQLException  {
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<ch.getChanges().size();i++){
            StringBuilder sb1=new StringBuilder(",SET t"+i+"="+ch.getChanges().get(i));
            sb.append(sb1);
        }
        String sql = "UPDATE changeinmeanbulktemperature SET fk.id.room="+ch.getFkIdRoom()+""+sb+" "+
                "WHERE id.changeinmeanbulktemperature="+ch.getIdChangeInMeanBulkTemperature()+";";
        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;
    }
    @Override
    public boolean delete(ChangeInMeanBulkTemperature ch) throws SQLException  {
        String sql = "DELETE FROM changesinmeanbulktemperature "+
                "WHERE id.changesinmeanbulktemperature="+ch.getIdChangeInMeanBulkTemperature()+";";

        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;
    }


}

