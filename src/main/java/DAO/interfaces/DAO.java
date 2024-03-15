package DAO.interfaces;

public interface DAO<T> {
    T create(T obj);
    T update(int id, T obj);
    T read(int id);
    int delete(int id);
    

}