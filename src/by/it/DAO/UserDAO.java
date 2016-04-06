package by.it.DAO;

import by.it.generate.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class UserDAO extends DAO implements InterfaceDAO<User> {
    @Override
    public List<User> getAll(String WHERE) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users " + WHERE + " ;";
        try (
                Statement statement = getDAO().getConnection().createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setIdUser((short) rs.getInt("id.user"));
                user.setLogin(rs.getString("login"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setAdmin(rs.getBoolean("admin"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            closeDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User read(int id) {
        List<User> users = getAll("WHERE id.user=" + id + " LIMIT 0,1");
        if (users.size() > 0) {
            return users.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(User user) throws SQLException {
        String sql = String.format(
                "insert INTO users(`Login`,`Password`,`Email`,`Admin`)" +
                        " values('%s','%s','%s',"+user.isAdmin()+");",
                user.getLogin(), user.getPassword(), user.getEmail()
        );
        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;

    }
    @Override
    public boolean update(User user) throws SQLException  {
        String sql = String.format(
                "UPDATE `users` SET `Login` = '%s', `Password` = '%s', `Email` = '%s', `admin`="+user.isAdmin()+" WHERE `id.user` = %d",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getIdUser()
        );
        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;
    }
    @Override
    public boolean delete(User user) throws SQLException  {
        String sql = String.format(
                "DELETE FROM `users` WHERE `id.user` = %d;", user.getIdUser()
        );
        getDAO();
        Boolean check=(0 < executeUpdate(sql));
        closeDAO();
        return check;
    }


}
