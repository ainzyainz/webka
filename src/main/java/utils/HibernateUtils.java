package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static javax.persistence.Persistence.createEntityManagerFactory;

public class HibernateUtils {

    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
            createEntityManagerFactory("alex");

    public static EntityManager getEntityManager() {

        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    public static void close() {
        ENTITY_MANAGER_FACTORY.close();
    }
}
