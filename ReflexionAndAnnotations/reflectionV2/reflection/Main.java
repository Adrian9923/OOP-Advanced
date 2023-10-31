package reflection;


import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> aClass = Reflection.class;
        System.out.println(aClass.getSimpleName());
        System.out.println(aClass.getSuperclass().getSimpleName());

        Class[] interfaces = aClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface.getSimpleName());
        }

        Reflection reflection = aClass.getDeclaredConstructor().newInstance();
        System.out.println(reflection);
    }
}
