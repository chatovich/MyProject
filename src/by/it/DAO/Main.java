package by.it.DAO;

import by.it.generate.User;

import java.sql.SQLException;
import java.util.List;

public class Main {

    static void showUsers(){
        //покажем все, что есть в таблице пользователей
        System.out.println("\nТаблица пользователей:");
        List<User> users=new UserDAO().getAll("");
        for (User each:users) System.out.println(each);

    }

    public static void main(String[] args) throws SQLException {
        //инициализация работы с базой
        DAO.getDAO();
        UserDAO userDAO = new UserDAO();
        showUsers();

        User user = new User("Сергей Иванович", "siivanov", "siivanov@mail.ru", false);
        user.setIdUser((short) 0);         //это в принципе лишнее, т.к. есть в конструкторе
//        user.setFk_Role(2);    //это в принципе лишнее, т.к. есть в конструкторе
        //добавим пользователя
        if (userDAO.create(user)) System.out.println("\nДобавлен:" + user);
        showUsers();

        //извлечем и обновим пользователя с email siivanov@mail.ru
        user = userDAO.getAll("WHERE `id.user`>'2'").get(0);
        user.setLogin("up_siivanov");
        if (userDAO.update(user)) System.out.println("\nИзменен:" + user);
        showUsers();

        //удалим пользователя
        if (userDAO.delete(user)) System.out.println("\nУдален:" + user);
        showUsers();
    }
}
