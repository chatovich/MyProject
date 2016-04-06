package by.it.DAO;

import java.sql.SQLException;

public class User {

    public User() {
    }

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    private int id=0;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    private String login;
    private String password;
    private String email;
    private Integer fk_Role=2;

    public Integer getFk_Role() {
        return fk_Role;
    }
    public void setFk_Role(Integer fk_Role) {
        this.fk_Role = fk_Role;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        String res="";
        try {

            res="User{" +
                    "id=" + id +
                    ", login='" + login + '\'' +
                    ", password='" + password + '\'' +
                    ", email='" + email + '\'' +
                    ", Role=" + new RoleDAO().getRole(fk_Role) +
                    '}';
        } catch (SQLException e) {
            res=e.toString();
        }
        return res;
    }
}
