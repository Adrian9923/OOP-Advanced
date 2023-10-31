package Java;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> reflectionClass = Reflection.class;
        Constructor<?>[] publicConstructors = reflectionClass.getConstructors();
        Constructor<?>[] allConstructors = reflectionClass.getDeclaredConstructors();

        Constructor<Reflection> constructorName = reflectionClass.getConstructor();

        Reflection reflection = reflectionClass.getDeclaredConstructor()
                .newInstance();
        System.out.println(reflection);
    }
}
