package Java;

import Java.core.Engine;
import Java.interfaces.Appender;
import Java.interfaces.Layout;
import Java.interfaces.Logger;
import Java.io.impl.ConsoleReader;
import Java.io.impl.ConsoleWriter;
import Java.io.interfaces.Reader;
import Java.io.interfaces.Writer;
import Java.models.appenders.ConsoleAppender;
import Java.models.enums.ReportLevel;
import Java.models.layouts.SimpleLayout;
import Java.models.layouts.XmlLayout;
import Java.models.loggers.MessageLogger;


public class Main {
    public static void main(String[] args) {
        Layout xmlLayout = new XmlLayout();

        Appender consoleAppender =
                new ConsoleAppender(xmlLayout);

        Logger logger = new MessageLogger(consoleAppender);

        logger.logFatal("3/31/2015 5:23:54 PM",
                "mscorlib.dll does not respond");
        logger.logCritical("3/31/2015 5:23:54 PM",
                "No connection string found in App.config");
    }
}
