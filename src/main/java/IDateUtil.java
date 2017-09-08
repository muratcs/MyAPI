import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public interface IDateUtil {

    int compareDateWithTime (LocalDateTime dateTime1, LocalDateTime dateTime2);

    int compareDate (LocalDateTime dateTime1, LocalDateTime dateTime2);

    long getDaysBetweenDates (LocalDateTime dateTime1, LocalDateTime dateTime2);

    LocalDateTime getDatePlusDays(LocalDateTime dateTime, long dayNumber);

    LocalDateTime getDateMinusDays (LocalDateTime dateTime, long dayNumber);

    String formatDate (LocalDateTime dateTime);

    String formatDateWithTime (LocalDateTime dateTime);

    LocalDateTime parseToDate (String dateText);

    LocalDateTime parseToDateWithTime (String dateText);

/*
    int aCompareDate (Date d1, Date d2);
    int bCompareDate(Date d1, Date d2);
    int cDaysbtwDates (Date d1, Date d2);
    Date dDayAfter(Date d, int day);
    Date eDayBefore(Date d, int day);
    String fFormatDate (Date date);
    String gFormatDate (Date date);
    Date hDateFromString (String x) throws ParseException;
    Date iDateFromString (String x);
*/
}
