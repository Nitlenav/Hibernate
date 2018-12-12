package ru.telenet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    //private static final EntityManagerFactory manager = Persistence.createEntityManagerFactory("")

    public static void main(String[] args) {
//        Session session = HibernatesessionFactory.getSessionFactory().openSession();
//        EntityTransaction transaction= session.beginTransaction();
//        session.beginTransaction();
        SessionFactory sessionFactory = HibernatesessionFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        List<Organizations> organizations = new ArrayList<Organizations>(session.createQuery("from Organizations o where o.code > 6500").list());
//                        VOrganizationsEntity.class).getResultList();
        for (Organizations org : organizations){
            System.out.println(org);
            for (Parametrs par : org.getParametrs())
            System.out.println(par);
        }

//        System.out.println(org.getCode() + " " + org.getFirmName() + " " + org.getInfo());
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
