package org.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {
    private static final SessionFactory session = buildSession();

    private static SessionFactory buildSession(){
        try{
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        }catch (Throwable e){
            System.out.println("Session is not open");
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSession(){
        return session;
    }

    public static void shutdown(){

    }
}
