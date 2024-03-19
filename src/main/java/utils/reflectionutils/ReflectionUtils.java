package utils.reflectionutils;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.util.Arrays;

public class ReflectionUtils {
    public static <T> T updateReflection(T object, T result, EntityManager entityManager) {
            Field[] objFields = object.getClass().getDeclaredFields();
            Arrays.stream(objFields)
                    .peek(q -> q.setAccessible(true))
                    .filter(field -> field.isAnnotationPresent(Id.class))
                    .forEach(field -> {
                        try {
                            field.set(object, field.get(result));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    });
        return entityManager.merge(object);
    }
}