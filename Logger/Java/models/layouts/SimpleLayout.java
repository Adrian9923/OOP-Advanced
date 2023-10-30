package Java.models.layouts;

import Java.interfaces.Layout;
import Java.models.enums.ReportLevel;


public class SimpleLayout implements Layout {

    public SimpleLayout() {
    }

    @Override
    public String format(ReportLevel level, String date, String message) {
        return String.format("%s - %s - %s", date, level.name(), message);
    }
}
