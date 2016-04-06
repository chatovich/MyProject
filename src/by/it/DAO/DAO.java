package by.it.DAO;

import by.it.Utils.SQL.Xampp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

class DAO {

    private static DAO dao; //синглтон для DAO
    private Connection connection;
    static DAO getDAO() throws SQLException {   //метод, который создает DAO или возвращает существующий экземпляр
        if (dao == null) {
            dao = new DAO();    //в момент создания DAO удобно создавать соединения.
                                //Но потом трудно их уничтожать. Нужно это делать явно из кода.
            Connection con = Xampp.getConnection();
            dao.connection=con;
        }
        return dao;
    }
     Connection getConnection(){
        return connection;
    }
    static void closeDAO() throws SQLException {   //метод, который уничтожает DAO
        dao.connection.close();
        dao = null; //Тут можно тоже закрывать соединение.
    }

    //Create Update Delete
    static int executeUpdate(String sql) {
        //System.out.println("--- SQL="+sql); //отладка
        int result = -1;
        try (Connection connection = Xampp.getConnection();
             Statement statement = connection.createStatement();) {
            result = statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

