package interfaces.dao;

import java.util.List;
import java.util.Optional;

public interface Read<T, ID> {
    Optional<T> findById(ID id);

    List<T> findAll();
}
