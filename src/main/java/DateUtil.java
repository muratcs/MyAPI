import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.*;


public class DateUtil implements IDateUtil {


    @Override
    public int compareDateWithTime(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        if (dateTime1.isBefore(dateTime2)){
            return  -1;
        }
        else if (dateTime1.isAfter(dateTime2)){
            return 1;
        }
        else{
            return 0;
        }
    }

    @Override
    public int compareDate(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        LocalDate date1 = dateTime1.toLocalDate();
        LocalDate date2 = dateTime2.toLocalDate();
        if (date1.isBefore(date2)){
            return  -1;
        }
        else if (date1.isAfter(date2)){
            return 1;
        }
        else return 0;
    }

    @Override
    public long getDaysBetweenDates(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        LocalDate date1 = dateTime1.toLocalDate();
        LocalDate date2 = dateTime2.toLocalDate();

        long between = ChronoUnit.DAYS.between(date1,date2);
        return Math.abs(between);
    }

    @Override
    public LocalDateTime getDatePlusDays(LocalDateTime dateTime, long dayNumber) {
        return dateTime.plusDays(dayNumber);
    }

    @Override
    public LocalDateTime getDateMinusDays(LocalDateTime dateTime, long dayNumber) {
        return dateTime.minusDays(dayNumber);
    }

    @Override
    public String formatDate(LocalDateTime dateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateTime.format(dateTimeFormatter);
    }

    @Override
    public String formatDateWithTime(LocalDateTime dateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dateTime.format(dateTimeFormatter);
    }

    @Override
    public LocalDateTime parseToDate(String dateText) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(dateText, dateTimeFormatter);
        return localDate.atStartOfDay();
    }

    @Override
    public LocalDateTime parseToDateWithTime(String dateText) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.parse(dateText, dateTimeFormatter);
    }


/*
    @Override
    public int aCompareDate(Date d1, Date d2) {

        if(d1.before(d2)){
            return -1;
        }
        else if(d1.after(d2)){
            return 1;
        }
        else {
            return 0;
        }

    }

    @Override
    public int bCompareDate(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        boolean sameDay = c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) &&
                c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR);
        if(sameDay){
            return 0;
        }
        else if(d1.after(d2)){
            return 1;
        }
        else{
            return -1;
        }
    }

    @Override
    public int cDaysbtwDates(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        c1.set(Calendar.HOUR_OF_DAY,0);
        c1.set(Calendar.MINUTE, 0);
        c1.set(Calendar.SECOND,0);
        c2.set(Calendar.HOUR_OF_DAY,0);
        c2.set(Calendar.MINUTE, 0);
        c2.set(Calendar.SECOND,0);
        int r = ((int) ((c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000)));
        return Math.abs(r);
    }

    @Override
    public Date dDayAfter(Date d, int day) {
        Date a = new Date(d.getTime() + ((long) day*24*3600*1000));
        return a;
    }

    @Override
    public Date eDayBefore(Date d, int day) {
        Date a = new Date(d.getTime() - ((long) day*24*3600*1000));
        return a;
    }

    @Override
    public String fFormatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }

    @Override
    public String gFormatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return sdf.format(date);
    }

    @Override
    public Date hDateFromString(String x) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse(x);
    }

    @Override
    public Date iDateFromString(String x) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date parse = null;
        try {
            parse = sdf.parse(x);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }
*/

}

