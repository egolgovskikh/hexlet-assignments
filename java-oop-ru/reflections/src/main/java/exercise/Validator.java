package exercise;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

// BEGIN
class Validator {
    public static List<String> validate(Object object) {
        Class<?> validatedClass = object.getClass();
        Field[] fields = validatedClass.getDeclaredFields();
        return Arrays.stream(fields)
                .filter(f ->
                        {
                            Object fieldValue = null;
                            try {
                                f.setAccessible(true);
                                fieldValue = f.get(object);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                            return f.isAnnotationPresent(NotNull.class) && fieldValue == null;
                        }
                )
                .map(Field::getName)
                .toList();
    }
}
// END
