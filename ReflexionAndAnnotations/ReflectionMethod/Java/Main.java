package Java;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> reflectionClass = Reflection.class;

        Method getEmail = reflectionClass.getMethod("getEmail",null);
        System.out.println(getEmail.getReturnType().getSimpleName());

        Reflection reflection = reflectionClass.getConstructor(String.class, String.class, String.class)
                .newInstance("Adrian", "abc.com", "abc.gmail.com");

        System.out.println(getEmail.invoke(reflection));


    }
}
