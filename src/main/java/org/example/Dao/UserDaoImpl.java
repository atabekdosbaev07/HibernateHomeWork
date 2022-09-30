package org.example.Dao;

import org.example.entity.User;
import org.example.util.Util;
import org.hibernate.Session;

import javax.persistence.Query;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class UserDaoImpl implements UserDao{


    public User create(User user) {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        System.out.println("User successfully created!");
        return user;
    }

    public User getById(int id) {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        User user = session.get(User.class,id);
        session.getTransaction().commit();
        session.close();
        return user;
    }


    public List<User> getAll() {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        List<User> usersList = session.createQuery("from User ").getResultList();
        session.getTransaction().commit();
        session.close();
        return usersList;
    }


    public List<User> getByName(String name,int age){
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        List<User> users = session.createQuery("FROM User e WHERE e.name =: name and e.age >: age").
                setParameter("name",name).setParameter("age",age).getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("found"+ users.size() + "user");
        return users;
    }
    public void updateByName(String name, int age) {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        Query query = session.createQuery("UPDATE User set age=:age WHERE name =:name")
                                .setParameter("name", name).setParameter("age", age);
        System.out.println("SuccessFully age changed " + name + " " + age);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public void update(int id, User newUser) {
        Session session = Util.getSession().openSession();
        session.beginTransaction();

        User user = session.get(User.class,id);
        user.setName(newUser.getName());
        user.setLastName(newUser.getLastName());
        user.setAge(newUser.getAge());
        session.save(user);

        session.getTransaction().commit();
        session.close();
        System.out.println("Updated");
    }

    public void delete(int id) {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        session.createQuery("delete from User where id =:id").setParameter("id",id);
        User user = session.get(User.class,id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }


    public void deleteByName(String name) {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM User WHERE name =:name").setParameter("name",name);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in User");
    }


    public void deleteAll() {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM User"); query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in User");
    }

}
