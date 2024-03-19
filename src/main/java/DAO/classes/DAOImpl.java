package DAO.classes;

import DAO.interfaces.DAO;
import utils.*;

import javax.persistence.EntityManager;
import java.util.logging.Level;
import java.util.logging.Logger;

import static utils.Constants.*;


public abstract class DAOImpl<T> implements DAO<T> {
    private final EntityManager entityManager = HibernateUtils.getEntityManager();

    private final Logger LOGGER = Logger.getLogger(DAOImpl.class.getName());

    public abstract Class<T> getEntityClass();

    public T create(T object) {
        if(object == null){
            LOGGER.log(Level.INFO, CREATE_FAILED_MSG);
            return null;
        }
        MyInterfaceToDAO<T> betweenBeginAndCommitted = () -> {
            entityManager.persist(object);
            return object;
        };
            UtilsInterface.superMethodInterface(betweenBeginAndCommitted, entityManager);
            LOGGER.log(Level.INFO, CREATE_SUCCESS_MSG);
        return object;
    }

    public T read(int id) {
        MyInterfaceToDAO<T> betweenBeginAndCommitted = () -> entityManager.find(getEntityClass(),id);
        T object = UtilsInterface.superMethodInterface(betweenBeginAndCommitted, entityManager);
        if (object == null) {
            LOGGER.log(Level.INFO,READ_FAILED_MSG);
        }
        LOGGER.log(Level.INFO,READ_SUCCESS_MSG);
        return object;
    }

    public T update(int id, T object) {
        MyInterfaceToDAO<T> betweenBeginAndCommitted = () -> {
            T result = entityManager.find(getEntityClass(), id);
            ReflectionUtils.updateReflection(object, result, entityManager);
            return result;
        };
        T result = UtilsInterface.superMethodInterface(betweenBeginAndCommitted, entityManager);
        if(result==null){
            LOGGER.log(Level.INFO, UPDATE_FAILED_MSG);
        }
        LOGGER.log(Level.INFO,UPDATE_SUCCESS_MSG);
        return result;
    }

    public int delete(int id) {
        MyInterfaceToDAO<T> betweenBeginAndCommitted = () -> {
            T object = entityManager.find(getEntityClass(), id);
            entityManager.remove(object);
            return object;
        };
        T object = UtilsInterface.superMethodInterface(betweenBeginAndCommitted, entityManager);
        if(object==null){
            LOGGER.log(Level.INFO, DELETE_FAILED_MSG);
            return -1;
        }
        LOGGER.log(Level.INFO, DELETE_SUCCESS_MSG);
        return id;
    }
    public EntityManager getEntityManager() {
        return entityManager;
    }
}

