package by.it.DAO;

import by.it.generate.CoefficientSForRoom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 06.04.2016.
 */
class CoefficientSForRoomDAO extends DAO implements InterfaceDAO<CoefficientSForRoom> {
    @Override
    public List<CoefficientSForRoom> getAll(String WHERE) {
        List<CoefficientSForRoom> changes = new ArrayList<>();
        String sql = "SELECT * FROM coefficientSForRoom " + WHERE + " ;";
        try (
                Statement statement = getDAO().getConnection().createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                CoefficientSForRoom ch = new CoefficientSForRoom();
                ch.setIdCoefficientSForRoom((short) rs.getInt("id.coefficientSForRoom"));
                ch.setFkIdRoom((short)rs.getInt("id.fk.room"));
                for (int i=0;i<6;i++)
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
    public CoefficientSForRoom read(int id) {
        List<CoefficientSForRoom> changes = getAll("WHERE id.coefficientSForRoom=" + id + " LIMIT 0,1");
        if (changes.size() > 0) {
            return changes.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(CoefficientSForRoom ch) throws SQLException {
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
                "INSERT INTO coefficientSForRoom (`fk.id.room`"+sb+") "+
                        "VALUES ('"+ch.getFkIdRoom()+"'"+sb1+");";

        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;

    }
    @Override
    public boolean update(CoefficientSForRoom ch) throws SQLException  {
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<ch.getS().size();i++){
            StringBuilder sb1=new StringBuilder(",SET s"+i+"="+ch.getS().get(i));
            sb.append(sb1);
        }
        String sql = "UPDATE coefficientSForRoom SET fk.id.room="+ch.getFkIdRoom()+""+sb+" "+
                "WHERE id.coefficientSForRoom="+ch.getIdCoefficientSForRoom()+";";
        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;
    }
    @Override
    public boolean delete(CoefficientSForRoom ch) throws SQLException  {
        String sql = "DELETE FROM coefficientSForRoom "+
                "WHERE id.coefficientSForRoom="+ch.getIdCoefficientSForRoom()+";";

        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;
    }
}


