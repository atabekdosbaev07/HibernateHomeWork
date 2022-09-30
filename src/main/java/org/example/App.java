package org.example;

import org.example.Dao.UserDao;
import org.example.Dao.UserDaoImpl;
import org.example.Service.UserService;
import org.example.Service.UserServiceImpl;
import org.example.entity.User;
import org.example.util.Util;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        UserDaoImpl userService = new UserDaoImpl();

        userService.create(new User("Aza","Aazimov",20));
        userService.create(new User("Nurseit","Bayaliev",18));
        userService.create(new User("Nurai","Jibek_kyzy",30));
        userService.create(new User("Aza","Mamanov",24));
        userService.create(new User("Janybek","Alishev",17));

        userService.updateByName("Aza",18);

        userService.deleteByName("Aza");

        System.out.println(userService.getByName("Aza",20));



    }
}
