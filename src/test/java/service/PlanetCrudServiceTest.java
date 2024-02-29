package service;

import entity.PlanetEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.FlywayUtils;
import utils.HibernateUtils;

import java.util.Optional;

class PlanetCrudServiceTest {
    PlanetCrudService service = new PlanetCrudService();

    @BeforeAll
    public static void setup() {FlywayUtils.migrateDatabase();}

    @Test
    void save() {

        PlanetEntity entity = new PlanetEntity();
        entity.setName("Earth");
        entity.setId("ERTH");

        service.save(entity);
        PlanetEntity actual = service.findById(entity.getId()).orElse(new PlanetEntity());
        Assertions.assertEquals(entity.getId(), actual.getId());

    }

    @Test
    void deleteById() {
        PlanetEntity entity = new PlanetEntity();
        entity.setName("TeraNova");
        entity.setId("TRNVA");
        service.save(entity);

        service.delete(entity);
        PlanetEntity actual = service.findById(entity.getId()).orElse(null);

        Assertions.assertNull(actual);
    }

    @Test
    void delete() {
        PlanetEntity entity = new PlanetEntity();
        entity.setName("Citrux");
        entity.setId("CTRUX");
        service.save(entity);

        service.delete(entity);
        PlanetEntity actual = service.findById(entity.getId()).orElse(null);

        Assertions.assertNull(actual);
    }

    @Test
    void findById() {
        PlanetEntity entity = new PlanetEntity();
        entity.setName("Fortima");
        entity.setId("FTMA");
        service.save(entity);

        String actual = service.findById(entity.getId()).orElse(new PlanetEntity()).getName();

        Assertions.assertEquals(entity.getName(), actual);
    }

    @Test
    void findAll() {
        PlanetEntity entity = new PlanetEntity();
        entity.setName("Calisto");
        entity.setId("CLSTO");

        int expected = service.findAll().size() + 1;

        service.save(entity);

        int actual = service.findAll().size();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void update() {
        PlanetEntity entity = new PlanetEntity();
        entity.setName("Exotrix");
        entity.setId("EXTRI");
        service.save(entity);
        entity.setName("Exotix");
        service.update(entity);

        PlanetEntity actual = service.findById(entity.getId()).orElse(new PlanetEntity());

        Assertions.assertEquals(entity.getName(), actual.getName());
    }
}