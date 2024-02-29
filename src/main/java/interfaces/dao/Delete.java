package interfaces.dao;

public interface Delete<T, ID> {
    void deleteById(ID id);

    void delete(T t);
}
