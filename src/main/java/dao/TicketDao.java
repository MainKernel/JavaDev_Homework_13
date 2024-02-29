package dao;

import entity.TicketEntity;
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

public class TicketDao implements Create<TicketEntity>, Read<TicketEntity, Long>,
        Update<TicketEntity>, Delete<TicketEntity, Long> {
    private final SessionFactory sessionFactory = HibernateUtils.getInstance().getSessionFactory();


    @Override
    public void save(TicketEntity ticketEntity) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(ticketEntity);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(Long aLong) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            TicketEntity ticketEntity = session.find(TicketEntity.class, aLong);
            session.remove(ticketEntity);
            transaction.commit();
        }
    }

    @Override
    public void delete(TicketEntity ticketEntity) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(ticketEntity);
            transaction.commit();
        }
    }

    @Override
    public Optional<TicketEntity> findById(Long aLong) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            TicketEntity ticketEntity = session.find(TicketEntity.class, aLong);
            transaction.commit();
            return Optional.ofNullable(ticketEntity);
        }
    }

    @Override
    public List<TicketEntity> findAll() {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "FROM TicketEntity";
            List<TicketEntity> list = session.createQuery(hql, TicketEntity.class).list();
            transaction.commit();
            return list;
        }
    }

    @Override
    public void update(TicketEntity ticketEntity) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(ticketEntity);
            transaction.commit();
        }
    }


}
