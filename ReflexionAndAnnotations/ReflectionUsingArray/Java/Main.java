package Java;

import java.lang.reflect.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        String[] stringArray = (String[]) Array.newInstance(String.class, 3);
        Array.set(stringArray, 0, "String Array");
        System.out.println(stringArray[0]);

    }
}
