package Java;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Method[] methods = Reflection.class.getDeclaredMethods();

        Method[] getters = Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("get") && method.getParameterCount() == 0)
                .sorted((f,s) -> f.getName().compareTo(s.getName()))
                .toArray(Method[]::new);

        Method[] setters = Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("set") && method.getParameterCount() == 1)
                .sorted((f,s) -> f.getName().compareTo(s.getName()))
                .toArray(Method[]::new);

        Arrays.stream(getters)
                .forEach(method -> System.out.printf("%s will return a field of the class %s\n", method.getName(), method.getReturnType().getName()));

        Arrays.stream(setters)
                .forEach(setter -> System.out.printf("%s will set a field of the class %s\n", setter.getName(), setter.getParameterTypes()[0].getName()));
    }
}
