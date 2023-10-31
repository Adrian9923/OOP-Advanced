package Java;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Ref;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> aClass = Reflection.class;
        System.out.println(aClass);
        System.out.println(aClass.getSuperclass());

        Class[] interfaces = aClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        Constructor constructor = Reflection.class.getConstructor(String.class,String.class,String.class);
        Reflection reflection = (Reflection) constructor.newInstance("Adrian","abc.com","abc.gmail.com");
        System.out.println(reflection);
    }
}
