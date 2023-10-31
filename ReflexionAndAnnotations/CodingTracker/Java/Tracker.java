package Java;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tracker {
    @Author(name = "Test")
    public static void printMethodsByAuthor(Class<?> aClass){
        Map<String, List<String>> methodsByAuthor = new HashMap<>();
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            Author annotation = method.getAnnotation(Author.class);
            if (annotation != null) {
                methodsByAuthor.putIfAbsent(annotation.name(), new ArrayList<>());
                methodsByAuthor.get(annotation.name()).add(method.getName() + "()");
            }
        }
        methodsByAuthor
                .forEach((entry, value) -> System.out.printf("%s: %s\n",entry,String.join(",",value)));
    }
}
