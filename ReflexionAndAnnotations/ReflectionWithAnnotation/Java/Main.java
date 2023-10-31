package Java;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> reflectionClass = Reflection.class;
        Ceva annotation = reflectionClass.getAnnotation(Ceva.class);

        System.out.println(annotation.name());

    }
}
