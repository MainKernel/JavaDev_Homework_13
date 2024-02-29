package service;

import dao.TicketDao;
import entity.TicketEntity;
import interfaces.dao.Create;
import interfaces.dao.Delete;
import interfaces.dao.Read;
import interfaces.dao.Update;

import java.util.List;
import java.util.Optional;

public class TicketCrudService implements Create<TicketEntity>, Read<TicketEntity, Long>,
        Update<TicketEntity>, Delete<TicketEntity, Long> {
    private final TicketDao dao = new TicketDao();
    @Override
    public void save(TicketEntity ticketEntity) {
        dao.save(ticketEntity);
    }

    @Override
    public void deleteById(Long aLong) {
        dao.deleteById(aLong);
    }

    @Override
    public void delete(TicketEntity ticketEntity) {
        dao.delete(ticketEntity);
    }

    @Override
    public Optional<TicketEntity> findById(Long aLong) {
        return dao.findById(aLong);
    }

    @Override
    public List<TicketEntity> findAll() {
        return dao.findAll();
    }

    @Override
    public void update(TicketEntity ticketEntity) {
        dao.update(ticketEntity);
    }
}
