import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
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

        Period period = Period.between(date1, date2);
        return Math.abs(period.getDays());
//        Duration duration = Duration.between(dateTime1, dateTime2);
//        return Math.abs(duration.toDays());
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
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat1);
        return sdf.format(date);
    }

    @Override
    public String gFormatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat2);
        return sdf.format(date);
    }

    @Override
    public Date hDateFromString(String x) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat1);
        return sdf.parse(x);
    }

    @Override
    public Date iDateFromString(String x) {

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat2);
        Date parse = null;
        try {
            parse = sdf.parse(x);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }

    public static void main (String args[]) throws ParseException {

//        Calendar c = Calendar.getInstance();
//        System.out.println(c.getTime());
//        SimpleDateFormat x = new SimpleDateFormat(dateFormat1);
//        Date d1 = new Date();
//        Date d2 = new Date();
//        d1.setTime(1112121111);
//        d2.setTime(1212121112);
//
//        System.out.println(x.format(d1));
//        IDateUtil DateUtil = new DateUtil();
//        DateUtil.aCompareDate(d1,d2);
//        //Calendar c1 = Calendar.getInstance();
//        //Calendar c2 = Calendar.getInstance();
//        //c1.setTime(d1);
//        //c2.setTime(d2);
//
//        //if(c2.before(c1))
//        //    System.out.println("less than "+x.format(d2));
//
//        System.out.println(DateUtil.bCompareDate(d1,d2));
//        long diff = d2.getTime() - d1.getTime();
//
//        System.out.println( (diff/(24*3600*1000)));
//
//
//
//
//        System.out.println("sdfsdf " + DateUtil.cDaysbtwDates(d1,d2) );
//
//        System.out.println("3. No of Days between 2 dates\n");
//        Calendar c1 = Calendar.getInstance(); 	//new GregorianCalendar();
//        Calendar c2 = Calendar.getInstance(); 	//new GregorianCalendar();
//        c1.set(1999, 0 , 20);
//        c2.set(1999, 0 , 22);
//        c1.setTime(d1);
//        c2.setTime(d2);
//        c1.set(Calendar.HOUR_OF_DAY,0);
//        c1.set(Calendar.MINUTE, 42);
//        c1.set(Calendar.SECOND,0);
//        //c2.set(c2.HOUR_OF_DAY,0);
//
//        System.out.println("Days Between "+c1.getTime()+" and "+ c2.getTime()+" is");
//        System.out.println((c2.getTime().getTime() - c1.getTime().getTime())/(24*3600*1000));
//        System.out.println(DateUtil.iDateFromString("32/02/1996 12:22"));
//        System.out.println(DateUtil.gFormatDate(d1));
//        System.out.println(d1);
//        System.out.println(DateUtil.dDayAfter(d1, 25));

        IDateUtil dateUtil = new DateUtil();

        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.now();
        LocalDateTime time1 = LocalDateTime.of(2017, 8, 24, 12, 43);
        LocalDateTime time2 = LocalDateTime.of(2017, 8, 23, 13, 43);
        System.out.println(dateUtil.getDaysBetweenDates(time2, time1));
        System.out.println(dateUtil.getDatePlusDays(time1, 10000));
        System.out.println(dateUtil.formatDateWithTime(time1));
        LocalTime time = LocalTime.now();
        System.out.println(time);
        System.out.println(localDateTime.toLocalDate());
        System.out.println(localDateTime.isBefore(localDateTime2));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        TemporalAccessor parse = dateTimeFormatter.parse("24/08/2015");
        LocalDate x = LocalDate.parse("24/08/2015", dateTimeFormatter);
//        LocalDateTime x = LocalDateTime.from(parse);
        System.out.println(dateUtil.parseToDateWithTime("24/08/2015 12:51"));
//        dateTime.isBefore()

    }

}

