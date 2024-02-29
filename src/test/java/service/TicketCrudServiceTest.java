package service;

import entity.ClientEntity;
import entity.PlanetEntity;
import entity.TicketEntity;
import org.junit.jupiter.api.*;
import utils.FlywayUtils;

import java.time.OffsetDateTime;
import java.util.Deque;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TicketCrudServiceTest {
    TicketCrudService crudService = new TicketCrudService();

    @BeforeAll
    public static void setup() {
        FlywayUtils.migrateDatabase();}

    @Test
    void save() {
        //Setup
        TicketEntity ticketEntity = new TicketEntity();
        List<PlanetEntity> all = new PlanetCrudService().findAll();
        PlanetEntity planet1 = all.getFirst();
        PlanetEntity planet2 = all.getLast();
        OffsetDateTime now = OffsetDateTime.now();
        ClientEntity client = new ClientCrudService().findAll().getFirst();
        ticketEntity.setClient(client);
        ticketEntity.setCreateAt(now);
        ticketEntity.setFromPlanet(planet1);
        ticketEntity.setToPlanet(planet2);

        crudService.save(ticketEntity);
        Long id = ticketEntity.getId();
        TicketEntity expected = crudService.findById(id).orElse(new TicketEntity());

        //Assertion
        Assertions.assertEquals(id, expected.getId());

    }

    @Test
    void deleteById() {
        //Setup
        TicketEntity ticketEntity = new TicketEntity();
        List<PlanetEntity> all = new PlanetCrudService().findAll();
        PlanetEntity planet1 = all.getFirst();
        PlanetEntity planet2 = all.getLast();
        OffsetDateTime now = OffsetDateTime.now();
        ClientEntity client = new ClientCrudService().findAll().getFirst();
        ticketEntity.setClient(client);
        ticketEntity.setCreateAt(now);
        ticketEntity.setFromPlanet(planet1);
        ticketEntity.setToPlanet(planet2);


        crudService.save(ticketEntity);
        crudService.deleteById(ticketEntity.getId());
        TicketEntity ticketEntity1 = crudService.findById(ticketEntity.getId()).orElse(null);

        //Assertion
        Assertions.assertNull(ticketEntity1);
    }

    @Test
    void delete() {
        //Setup
        TicketEntity ticketEntity = new TicketEntity();
        List<PlanetEntity> all = new PlanetCrudService().findAll();
        PlanetEntity planet1 = all.getFirst();
        PlanetEntity planet2 = all.getLast();
        OffsetDateTime now = OffsetDateTime.now();
        ClientEntity client = new ClientCrudService().findAll().getFirst();
        ticketEntity.setClient(client);
        ticketEntity.setCreateAt(now);
        ticketEntity.setFromPlanet(planet1);
        ticketEntity.setToPlanet(planet2);
        crudService.save(ticketEntity);
        crudService.delete(ticketEntity);
        TicketEntity ticketEntity1 = crudService.findById(ticketEntity.getId()).orElse(null);

        //Assertion
        Assertions.assertNull(ticketEntity1);
    }

    @Test
    void findById() {
        //Setup
        TicketEntity ticketEntity = new TicketEntity();
        List<PlanetEntity> all = new PlanetCrudService().findAll();
        PlanetEntity planet1 = all.getFirst();
        PlanetEntity planet2 = all.getLast();
        OffsetDateTime now = OffsetDateTime.now();
        ClientEntity client = new ClientCrudService().findAll().getFirst();
        ticketEntity.setClient(client);
        ticketEntity.setCreateAt(now);
        ticketEntity.setFromPlanet(planet1);
        ticketEntity.setToPlanet(planet2);
        crudService.save(ticketEntity);
        Long expected = ticketEntity.getId();
        Long actual = crudService.findById(ticketEntity.getId()).orElse(new TicketEntity()).getId();

        //Assertion
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findAll() {
        //Setup
        TicketEntity ticketEntity = new TicketEntity();
        List<PlanetEntity> all = new PlanetCrudService().findAll();
        PlanetEntity planet1 = all.getFirst();
        PlanetEntity planet2 = all.getLast();
        OffsetDateTime now = OffsetDateTime.now();
        ClientEntity client = new ClientCrudService().findAll().getFirst();
        ticketEntity.setClient(client);
        ticketEntity.setCreateAt(now);
        ticketEntity.setFromPlanet(planet1);
        ticketEntity.setToPlanet(planet2);

        int expected = crudService.findAll().size() + 1;
        crudService.save(ticketEntity);
        int actual = crudService.findAll().size();

        //Assertion
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void update() {
        //Setup
        TicketEntity ticketEntity = new TicketEntity();
        List<PlanetEntity> all = new PlanetCrudService().findAll();
        PlanetEntity planet1 = all.getFirst();
        PlanetEntity planet2 = all.get(3);
        OffsetDateTime now = OffsetDateTime.now();
        ClientEntity client = new ClientCrudService().findAll().getFirst();
        ticketEntity.setClient(client);
        ticketEntity.setCreateAt(now);
        ticketEntity.setFromPlanet(planet1);
        ticketEntity.setToPlanet(planet2);
        crudService.save(ticketEntity);
        Long id = ticketEntity.getId();
        ticketEntity.setFromPlanet(all.getLast());
        crudService.update(ticketEntity);
        TicketEntity ticketEntity1 = crudService.findById(id).orElse(new TicketEntity());

        //Assertion
        Assertions.assertEquals(ticketEntity1.getFromPlanet(), ticketEntity.getFromPlanet());
    }
}