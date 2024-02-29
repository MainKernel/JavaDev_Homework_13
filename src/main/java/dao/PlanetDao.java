package dao;

import entity.PlanetEntity;
import interfaces.dao.Create;
import interfaces.dao.Delete;
import interfaces.dao.Read;
import interfaces.dao.Update;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.List;
import java.util.Optional;

public class PlanetDao implements Create<PlanetEntity>, Read<PlanetEntity, String>,
        Update<PlanetEntity>, Delete<PlanetEntity, String> {
    private final SessionFactory sessionFactory = HibernateUtils.getInstance().getSessionFactory();

    @Override
    public void save(PlanetEntity planetEntity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(planetEntity);
            transaction.commit();
        }
    }

    @Override
    public Optional<PlanetEntity> findById(String s) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            PlanetEntity planetEntity = session.find(PlanetEntity.class, s);
            transaction.commit();
            return Optional.ofNullable(planetEntity);
        }
    }

    @Override
    public List<PlanetEntity> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "FROM PlanetEntity ";
            List<PlanetEntity> resultList = session.createQuery(hql, PlanetEntity.class).getResultList();
            transaction.commit();
            return resultList;
        }
    }

    @Override
    public void update(PlanetEntity planetEntity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(planetEntity);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(String s) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            PlanetEntity planetEntity = session.find(PlanetEntity.class, s);
            session.remove(planetEntity);
            transaction.commit();
        }
    }

    @Override
    public void delete(PlanetEntity planetEntity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(planetEntity);
            transaction.commit();
        }
    }
}
