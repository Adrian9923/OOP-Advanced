package Java;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<Reflection> reflectionClass = Reflection.class;

        Field[] declaredFields = reflectionClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("Name: " + field.getName() + " Type: " + field.getType().getSimpleName());
        }

        Reflection reflection = reflectionClass.getDeclaredConstructor(String.class, String.class, String.class)
                .newInstance("Adrian", "abc.com", "abc.gmail.com");

        Field name = reflectionClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(reflection, "Razvan");
        System.out.println(reflection);

    }
}
