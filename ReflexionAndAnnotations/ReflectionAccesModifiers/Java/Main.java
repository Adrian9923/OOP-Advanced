package Java;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> reflectionClass = Reflection.class;

        for (Field field : reflectionClass.getDeclaredFields()) {
            int modifiers = field.getModifiers();
            boolean isPrivate = Modifier.isPrivate(modifiers);
            System.out.println(isPrivate);
        }


    }
}
