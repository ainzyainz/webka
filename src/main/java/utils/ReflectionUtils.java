package utils;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import java.lang.reflect.Field;
import java.util.Arrays;

public class ReflectionUtils {
    public static <T> void updateReflection(T object, T result, EntityManager entityManager) {
        Field[] objFields = object.getClass().getDeclaredFields();
        Arrays.stream(objFields)
                .peek(q -> q.setAccessible(true))
                .filter(field -> field.isAnnotationPresent(Column.class))
                .forEach(field -> {
                    try {
                        field.set(result, field.get(object));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
        entityManager.merge(result);
    }
}