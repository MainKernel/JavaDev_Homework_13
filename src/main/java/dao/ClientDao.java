package dao;

import entity.ClientEntity;
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

public class ClientDao implements Create<ClientEntity>, Read<ClientEntity, Long>,
        Update<ClientEntity>, Delete<ClientEntity,Long> {

    private final SessionFactory sessionFactory = HibernateUtils.getInstance().getSessionFactory();

    public void save(ClientEntity client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        }
    }

    public Optional<ClientEntity> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            ClientEntity clientEntity = session.find(ClientEntity.class, id);
            transaction.commit();
            return Optional.ofNullable(clientEntity);
        }
    }

    @Override
    public List<ClientEntity> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "FROM ClientEntity";
            List<ClientEntity> resultList = session.createQuery(hql, ClientEntity.class).getResultList();
            transaction.commit();
            return resultList;
        }
    }

    public void update(ClientEntity client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(client);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            ClientEntity clientEntity = session.find(ClientEntity.class, id);
            session.remove(clientEntity);
            transaction.commit();
        }
    }

    public void delete(ClientEntity client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(client);
            transaction.commit();
        }
    }
}
