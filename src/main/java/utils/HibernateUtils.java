package utils;

import entity.ClientEntity;
import entity.PlanetEntity;
import entity.TicketEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static final HibernateUtils INSTANCE;
    private static final SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUtils();

        sessionFactory = new Configuration()
                .addAnnotatedClass(ClientEntity.class)
                .addAnnotatedClass(PlanetEntity.class)
                .addAnnotatedClass(TicketEntity.class)
                .buildSessionFactory();
        FlywayUtils.migrateDatabase();
    }

    private HibernateUtils() {
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static HibernateUtils getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }

}

