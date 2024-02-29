package service;

import dao.ClientDao;
import entity.ClientEntity;
import interfaces.dao.Create;
import interfaces.dao.Delete;
import interfaces.dao.Read;
import interfaces.dao.Update;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public class ClientCrudService implements Create<ClientEntity>, Read<ClientEntity, Long>,
        Update<ClientEntity>, Delete<ClientEntity, Long> {
    ClientDao dao = new ClientDao();


    @Override
    public void save(ClientEntity client) {
        if (clientValidation(client)) {
            dao.save(client);
        } else {
            throw new IllegalArgumentException("Invalid client name");
        }
    }

    @Override
    public void deleteById(Long aLong) {
        dao.deleteById(aLong);
    }

    @Override
    public void delete(ClientEntity client) {
        dao.delete(client);
    }

    @Override
    public Optional<ClientEntity> findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<ClientEntity> findAll() {
        return dao.findAll();
    }

    @Override
    public void update(ClientEntity client) {
        if (clientValidation(client)) {
            dao.update(client);
        } else {
            throw new IllegalArgumentException("Invalid client name");
        }
    }

    private boolean clientValidation(@NotNull ClientEntity client) {
        return client.getName().length() >= 3 & client.getName().length() <= 200;
    }
}
