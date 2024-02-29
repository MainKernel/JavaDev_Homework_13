package service;

import dao.TicketDao;
import entity.PlanetEntity;
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
        if (validateTicket(ticketEntity)) {
            dao.save(ticketEntity);
        } else {
            throw new IllegalArgumentException();
        }
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
        if (validateTicket(ticketEntity)) {
            dao.update(ticketEntity);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkClient(TicketEntity ticket) {
        return ticket.getClient() != null & ticket.getClient().getId() != null;
    }

    private boolean checkPlanet(TicketEntity ticket) {
        PlanetEntity toPlanet = ticket.getToPlanet();
        PlanetEntity fromPlanet = ticket.getFromPlanet();
        return toPlanet != null && fromPlanet != null & toPlanet.getId() != null;
    }

    private boolean validateTicket(TicketEntity ticket) {
        return checkClient(ticket) & checkPlanet(ticket);
    }
}
