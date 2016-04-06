package by.it.DAO;

import by.it.generate.ChangeInTemperatureOfSlab;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 06.04.2016.
 */
class ChangeSlabTDAO  extends DAO implements InterfaceDAO<ChangeInTemperatureOfSlab>  {
    @Override
    public List<ChangeInTemperatureOfSlab> getAll(String WHERE) {
        List<ChangeInTemperatureOfSlab> changes = new ArrayList<>();
        String sql = "SELECT * FROM changeInTemperatureOfSlab " + WHERE + " ;";
        try (
                Statement statement = getDAO().getConnection().createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                ChangeInTemperatureOfSlab ch = new ChangeInTemperatureOfSlab();
                ch.setIdChangeInTemperatureOfSlab((short) rs.getInt("id.changeInTemperatureOfSlab"));
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
    public ChangeInTemperatureOfSlab read(int id) {
        List<ChangeInTemperatureOfSlab> changes = getAll("WHERE id.changeInTemperatureOfSlab=" + id + " LIMIT 0,1");
        if (changes.size() > 0) {
            return changes.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(ChangeInTemperatureOfSlab ch) throws SQLException {
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
                "INSERT INTO changeInTemperatureOfSlab (`fk.id.room`"+sb+") "+
                        "VALUES ('"+ch.getFkIdRoom()+"'"+sb1+");";

        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;

    }
    @Override
    public boolean update(ChangeInTemperatureOfSlab ch) throws SQLException  {
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<ch.getChanges().size();i++){
            StringBuilder sb1=new StringBuilder(",SET t"+i+"="+ch.getChanges().get(i));
            sb.append(sb1);
        }
        String sql = "UPDATE changeInTemperatureOfSlab SET fk.id.room="+ch.getFkIdRoom()+""+sb+" "+
                "WHERE id.changeInTemperatureOfSlab="+ch.getIdChangeInTemperatureOfSlab()+";";
        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;
    }
    @Override
    public boolean delete(ChangeInTemperatureOfSlab ch) throws SQLException  {
        String sql = "DELETE FROM changeInTemperatureOfSlab "+
                "WHERE id.changeInTemperatureOfSlab="+ch.getIdChangeInTemperatureOfSlab()+";";

        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;
    }
}