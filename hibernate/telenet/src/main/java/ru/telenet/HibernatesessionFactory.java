package ru.telenet;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernatesessionFactory {
    private static SessionFactory sessionFactory;
    private static Configuration configuration;
    private static StandardServiceRegistry registry;

    private HibernatesessionFactory() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            configuration = new Configuration().configure("hibernate.cfg.xml");
            registry = new StandardServiceRegistryBuilder().configure().build();
            sessionFactory = configuration.buildSessionFactory(registry);
            return sessionFactory;
        }
        else return sessionFactory;
    }
}
