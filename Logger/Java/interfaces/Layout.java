package Java.interfaces;

import Java.models.enums.ReportLevel;


public interface Layout {

    String format(ReportLevel level, String date, String message);
}
