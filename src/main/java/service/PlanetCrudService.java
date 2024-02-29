package service;

import dao.PlanetDao;
import entity.PlanetEntity;
import interfaces.dao.Create;
import interfaces.dao.Delete;
import interfaces.dao.Read;
import interfaces.dao.Update;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class PlanetCrudService implements Create<PlanetEntity>, Read<PlanetEntity, String>,
        Update<PlanetEntity>, Delete<PlanetEntity, String> {
    PlanetDao dao = new PlanetDao();

    @Override
    public void save(PlanetEntity planetEntity) {
        if (planetValidation(planetEntity)) {
            dao.save(planetEntity);
        } else {
            throw new IllegalArgumentException("invalid credentials");
        }
    }

    @Override
    public void deleteById(String s) {
        dao.deleteById(s);
    }

    @Override
    public void delete(PlanetEntity planetEntity) {
        dao.delete(planetEntity);
    }

    @Override
    public Optional<PlanetEntity> findById(String s) {
        return dao.findById(s);
    }

    @Override
    public List<PlanetEntity> findAll() {
        return dao.findAll();
    }

    @Override
    public void update(PlanetEntity planetEntity) {
        if (planetValidation(planetEntity)) {
            dao.update(planetEntity);
        } else {
            throw new IllegalArgumentException("Invalid credentials");
        }
    }


    private boolean planetValidation(@org.jetbrains.annotations.NotNull PlanetEntity planet) {

        Pattern idPattern = Pattern.compile("^[A-Z0-9]+$");
        int idLength = planet.getId().length();

        boolean idValidation = idPattern.matcher(planet.getId()).matches() & idLength >= 1 & idLength <= 200;
        boolean nameValidation = !planet.getName().isEmpty() & planet.getName().length() <= 500;

        return idValidation & nameValidation;
    }
}
