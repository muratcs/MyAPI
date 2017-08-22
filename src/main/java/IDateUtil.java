import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;

public interface IDateUtil {

    String dateFormat1 = "dd/MM/yyyy";
    String dateFormat2 = "dd/MM/yyyy HH:mm";

    int aCompareDate (Date d1, Date d2);

    int bCompareDate(Date d1, Date d2);

    int cDaysbtwDates (Date d1, Date d2);

    Date dDayAfter(Date d, int day);

    Date eDayBefore(Date d, int day);

    String fFormatDate (Date date);

    String gFormatDate (Date date);

    Date hDateFromString (String x) throws ParseException;

    Date iDateFromString (String x);

}
