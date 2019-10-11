package Util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class UtilDate {
    public static Date localdateToDate(LocalDate localDate) {
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        return date;
    }
}
