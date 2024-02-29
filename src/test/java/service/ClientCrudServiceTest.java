package service;

import entity.ClientEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClientCrudServiceTest {
    ClientCrudService crudService = new ClientCrudService();

    @Test
    void save() {

        ClientEntity client = new ClientEntity("Johny Clearman");
        crudService.save(client);
        Long expected = client.getId();
        Long actual = crudService.findById(expected).orElse(new ClientEntity()).getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void deleteById() {

        ClientEntity client = new ClientEntity("Johny Silverhand");
        crudService.save(client);
        crudService.deleteById(client.getId());
        Long actual = crudService.findById(client.getId()).orElse(new ClientEntity()).getId();

        Assertions.assertNull(actual);
    }

    @Test
    void delete() {

        ClientEntity client = new ClientEntity("Johny Silverhand");
        crudService.save(client);
        crudService.delete(client);
        Long actual = crudService.findById(client.getId()).orElse(new ClientEntity()).getId();

        Assertions.assertNull(actual);
    }

    @Test
    void findById() {

        ClientEntity client = new ClientEntity("Johny Silverhand");
        crudService.save(client);
        Long expected = client.getId();
        Long actual = crudService.findById(client.getId()).orElse(new ClientEntity()).getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findAll() {
        int expected = crudService.findAll().size() + 1;
        ClientEntity client = new ClientEntity("Johny Silverhand");
        crudService.save(client);

        int actual = crudService.findAll().size();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void update() {

        ClientEntity client = new ClientEntity("Alex Johnson");
        crudService.save(client);
        client.setName("Alex Freeman");
        crudService.update(client);

        ClientEntity client1 = crudService.findById(client.getId()).orElse(new ClientEntity());

        Assertions.assertEquals(client.getName(), client1.getName());
    }
}