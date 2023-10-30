package Java.factories;

import Java.interfaces.Appender;
import Java.interfaces.Layout;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
public class AppendFactory {
    private static final String CLASS_PATH = "models.appenders.";

    protected void AppenderFactory() {
    }

    public static Appender create(String appenderType, Layout layout) {
        try {
            Class<?> appenderClass = Class.forName(CLASS_PATH + appenderType);
            Constructor<?> declaredConstructor = appenderClass.getDeclaredConstructor(Layout.class);

            return  (Appender) declaredConstructor.newInstance(layout);
        } catch (ClassNotFoundException
                | NoSuchMethodException
                | InstantiationException
                | IllegalAccessException
                | InvocationTargetException e) {
//            e.printStackTrace();
            return null;
        }
    }
}
