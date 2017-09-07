import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestDateUtil {

    private static final LocalDateTime dateTime1 = LocalDateTime.of(2017,8,24,12,10);
    private static final LocalDateTime dateTime2 = LocalDateTime.of(2017,8,24,13,10);
    private static final LocalDateTime dateTime3 = LocalDateTime.of(2017,8,24,12,10);
    private static final LocalDateTime dateTime4 = LocalDateTime.of(1996,9,10,12,10);
    private static final LocalDateTime dateTime5 = LocalDateTime.of(1996,8,24,13,10);
    private static final LocalDateTime dateTime6 = LocalDateTime.of(2014,8,24,13,10);
    private static final LocalDateTime dateTime7 = LocalDateTime.of(1996,2,22,1,0);
    private static final LocalDateTime dateTime8 = LocalDateTime.of(1996,2,23,0,0);



    // Static final ekleme bu durumda avantajlımı?
    // Is it bad practice to use more than one assertEquals in one test case

    @Test
    public void testWhenFirstDateTimeIsLessThanSecond_A() {
        IDateUtil dateUtil = new DateUtil();

        Assert.assertEquals(-1, dateUtil.compareDateWithTime(dateTime1, dateTime2));
        Assert.assertEquals(-1, dateUtil.compareDateWithTime(dateTime4, dateTime1));
        Assert.assertEquals(-1, dateUtil.compareDateWithTime(dateTime5, dateTime4));

    }

    @Test
    public void testWhenFirstDateTimeIsGreaterThanSecond_A() {
        IDateUtil dateUtil = new DateUtil();

        int result = dateUtil.compareDateWithTime(dateTime2, dateTime1);
        Assert.assertEquals(1, result);
    }

    @Test
    public void testWhenFirstDateTimeIsEqualToSecond_A() {
        IDateUtil dateUtil = new DateUtil();

        int result = dateUtil.compareDateWithTime(dateTime1, dateTime3);
        Assert.assertEquals(0, result);
    }


    @Test
    public void testWhenFirstDateIsGreaterThanSecond_B(){
        IDateUtil dateUtil = new DateUtil();
        Assert.assertEquals(-1, dateUtil.compareDate(dateTime4, dateTime1));
    }

    @Test
    public void testWhenFirstDateIsLessThanSecond_B(){
        IDateUtil dateUtil = new DateUtil();
        Assert.assertEquals(1, dateUtil.compareDate(dateTime1, dateTime4));
    }

    @Test
    public void testWhenFirstDateIsEqualToSecond_B(){
        IDateUtil dateUtil = new DateUtil();
        Assert.assertEquals(0, dateUtil.compareDate(dateTime1, dateTime2));
    }

    @Test
    public void testDaysBetweenDates_C1() {
        IDateUtil dateUtil = new DateUtil();
        Assert.assertEquals(0, dateUtil.getDaysBetweenDates(dateTime1, dateTime2));
    }

    @Test
    public void testDaysBetweenDates_C2() {
        IDateUtil dateUtil = new DateUtil();
        Assert.assertEquals(1, dateUtil.getDaysBetweenDates(dateTime7, dateTime8));
    }


    @Test
    public void testDaysBetweenDates_C3() {
        IDateUtil dateUtil = new DateUtil();
        Assert.assertEquals(17, dateUtil.getDaysBetweenDates(dateTime4, dateTime5));
    }

    @Test
    public void testDaysAfter_D1() {
        IDateUtil dateUtil = new DateUtil();
        Assert.assertEquals(dateTime8, dateUtil.getDatePlusDays(dateTime7.toLocalDate().atStartOfDay(), 1));
    }

    @Test
    public void testDaysAfter_D2() {
        IDateUtil dateUtil = new DateUtil();
        Assert.assertEquals(dateTime4.plusHours(1), dateUtil.getDatePlusDays(dateTime5,17));
}

    @Test
    public void testDaysAfter_D3() {
        IDateUtil dateUtil = new DateUtil();
        Assert.assertEquals(dateTime1, dateUtil.getDatePlusDays(dateTime4,7653));
    }

    @Test
    public void testDaysBefore_E() {
        IDateUtil dateUtil = new DateUtil();
        Assert.assertEquals(dateTime4, dateUtil.getDateMinusDays(dateTime1,7653));
    }

    @Test
    public void testFormatDate_F1() {
        IDateUtil dateUtil = new DateUtil();
        Assert.assertEquals("24/08/2017",dateUtil.formatDate(dateTime1));
    }

    @Test
    public void testFormatDate_F2() {
        IDateUtil dateUtil = new DateUtil();
        Assert.assertEquals("22/02/1996",dateUtil.formatDate(dateTime7));
    }

    @Test
    public void testFormatDateTime_G1() {
        IDateUtil dateUtil = new DateUtil();
        Assert.assertEquals("24/08/2017 12:10",dateUtil.formatDateWithTime(dateTime1));
    }

    @Test
    public void testFormatDateTime_G2() {
        IDateUtil dateUtil = new DateUtil();
        Assert.assertEquals("22/02/1996 01:00",dateUtil.formatDateWithTime(dateTime7));
    }

    @Test
    public void testParseDate_H1() {
        IDateUtil dateUtil = new DateUtil();
        Assert.assertEquals(dateTime1.truncatedTo(ChronoUnit.DAYS),dateUtil.parseToDate("24/08/2017"));
    }

    @Test
    public void testParseDate_H2() {
        IDateUtil dateUtil = new DateUtil();
        Assert.assertEquals(dateTime8,dateUtil.parseToDate("23/02/1996"));
    }

    @Test
    public void testParseDateTime_I1() {
        IDateUtil dateUtil = new DateUtil();
        Assert.assertEquals(dateTime6,dateUtil.parseToDateWithTime("24/08/2014 13:10"));
    }

    @Test
    public void testParseDateTime_I2() {
        IDateUtil dateUtil = new DateUtil();
        Assert.assertEquals(dateTime7,dateUtil.parseToDateWithTime("22/02/1996 01:00"));
    }


//    @Test
//    public void testWhenFirstDateIsLessThanSecond_A() throws ParseException {
//        IDateUtil dateUtil = new DateUtil();
//        Date d1 = dateUtil.iDateFromString("29/02/1994 13:08");
//        Date d2 = dateUtil.iDateFromString("22/02/1996 13:09");
//
//        d1.setTime(1112121111);
//        d2.setTime(1112121121);
//
//        int result = dateUtil.aCompareDate(d1, d2);
//        Assert.assertEquals(-1, result);
//    }
//
//    @Test
//    public void testWhenFirstDateIsGreaterThanSecond_A() throws ParseException {
//        IDateUtil dateUtil = new DateUtil();
//
//        Date d1 = dateUtil.iDateFromString("22/02/1996 13:10");
//        Date d2 = dateUtil.iDateFromString("22/02/1996 13:09");
//
//        int result = dateUtil.aCompareDate(d1, d2);
//        Assert.assertEquals(1, result);
//
//        d1 = dateUtil.iDateFromString("22/02/2017 13:10");
//        d2 = dateUtil.iDateFromString("22/02/1996 13:09");
//
//        result = dateUtil.aCompareDate(d1, d2);
//        Assert.assertEquals(1, result);
//    }
//
//    @Test
//    public void testWhenDatesAreEqual_A() throws ParseException {
//        IDateUtil dateUtil = new DateUtil();
//
//        Date d1 = dateUtil.iDateFromString("22/02/1996 13:10");
//        Date d2 = dateUtil.iDateFromString("22/02/1996 13:10");
//
//        int result = dateUtil.aCompareDate(d1, d2);
//        Assert.assertEquals(0, result);
//
//        d1.setTime(1112121111);
//        d2.setTime(1112121111);
//
//        result = dateUtil.aCompareDate(d1, d2);
//        Assert.assertEquals(0, result);
//    }
//
//    @Test
//    public void testWhenFirstDateIsLessThanSecond_B(){
//        IDateUtil dateUtil = new DateUtil();
//        Date d1 = dateUtil.iDateFromString("29/02/1994 13:08");
//        Date d2 = dateUtil.iDateFromString("22/02/1996 13:09");
//
//        int result = dateUtil.bCompareDate(d1, d2);
//        Assert.assertEquals(-1, result);
//    }
//
//    @Test
//    public void testWhenFirstDateIsGreaterThanSecond_B() throws ParseException {
//        IDateUtil dateUtil = new DateUtil();
//
//        Date d1 = dateUtil.iDateFromString("23/02/1996 13:10");
//        Date d2 = dateUtil.iDateFromString("22/02/1996 13:09");
//
//        int result = dateUtil.bCompareDate(d1, d2);
//        Assert.assertEquals(1, result);
//
//        d1 = dateUtil.iDateFromString("22/02/2017 13:10");
//        d2 = dateUtil.iDateFromString("22/02/1996 13:09");
//
//        result = dateUtil.bCompareDate(d1, d2);
//        Assert.assertEquals(1, result);
//    }
//
//    @Test
//    public void testWhenDatesAreEqual_B() throws ParseException {
//        IDateUtil dateUtil = new DateUtil();
//
//        Date d1 = dateUtil.iDateFromString("22/02/1996 13:10");
//        Date d2 = dateUtil.iDateFromString("22/02/1996 19:10");
//
//        int result = dateUtil.cDaysbtwDates(d1, d2);
//        Assert.assertEquals(0, result);
//
//        d1 = dateUtil.iDateFromString("22/02/1996 13:10");
//        d2 = dateUtil.iDateFromString("23/02/1996 19:10");
//
//        result = dateUtil.cDaysbtwDates(d1, d2);
//        Assert.assertEquals(1, result);
//    }
//
//    @Test
//    public void testDaysBetweenDates_C() throws ParseException {
//        IDateUtil dateUtil = new DateUtil();
//
//        Date d1 = dateUtil.iDateFromString("22/02/1996 13:10");
//        Date d2 = dateUtil.iDateFromString("22/02/1996 19:10");
//
//        int result = dateUtil.cDaysbtwDates(d1, d2);
//        Assert.assertEquals(0, result);
//
//        d1 = dateUtil.iDateFromString("22/02/1996 13:10");
//        d2 = dateUtil.iDateFromString("23/02/1996 19:10");
//
//        result = dateUtil.cDaysbtwDates(d1, d2);
//        Assert.assertEquals(1, result);
//
//        d1 = dateUtil.iDateFromString("22/02/1996 13:10");
//        d2 = dateUtil.iDateFromString("23/03/1996 19:10");
//
//        result = dateUtil.cDaysbtwDates(d1, d2);
//        Assert.assertEquals(30, result);
//
//    }
//
//    @Test
//    public void testDaysAfter_D() throws ParseException {
//        IDateUtil dateUtil = new DateUtil();
//
//        Date d1 = dateUtil.iDateFromString("22/02/1996 13:10");
//        Date d2 = dateUtil.iDateFromString("23/02/1996 13:10");
//
//        Date result = dateUtil.dDayAfter(d1, 1);
//        Assert.assertEquals(d2, result);
//
//        d1 = dateUtil.iDateFromString("16/08/2017 13:10");
//        d2 = dateUtil.iDateFromString("01/09/2017 13:10");
//
//        result = dateUtil.dDayAfter(d1, 16);
//        Assert.assertEquals(d2, result);
//
//        d1 = dateUtil.iDateFromString("16/08/2017 13:10");
//        d2 = dateUtil.iDateFromString("25/10/2017 13:10");
//
//        result = dateUtil.dDayAfter(d1, 70);
//        Assert.assertEquals(d2, result);
//    }
//
//    @Test
//    public void testDaysBefore_E() throws ParseException {
//        IDateUtil dateUtil = new DateUtil();
//
//        Date d1 = dateUtil.iDateFromString("22/02/1996 13:10");
//        Date d2 = dateUtil.iDateFromString("23/02/1996 13:10");
//
//        Date result = dateUtil.eDayBefore(d2, 1);
//        Assert.assertEquals(d1, result);
//
//        d1 = dateUtil.iDateFromString("16/08/2017 13:10");
//        d2 = dateUtil.iDateFromString("01/09/2017 13:10");
//
//        result = dateUtil.eDayBefore(d2, 16);
//        Assert.assertEquals(d1, result);
//
//        d1 = dateUtil.iDateFromString("16/08/2017 13:10");
//        d2 = dateUtil.iDateFromString("25/10/2017 13:10");
//
//        result = dateUtil.eDayBefore(d2, 70);
//        Assert.assertEquals(d1, result);
//    }
//
//    @Test
//    public void testFormatDate_F() {
//        IDateUtil dateUtil = new DateUtil();
//
//        Calendar c1 = new GregorianCalendar(2017,7,16,15,0,0);
//        String result1 = dateUtil.fFormatDate(c1.getTime());
//        Assert.assertEquals("16/08/2017",result1);
//
//        Calendar c2 = new GregorianCalendar(2027,8,30,15,0,0);
//        String result2 = dateUtil.fFormatDate(c2.getTime());
//        Assert.assertEquals("30/09/2027",result2);
//
//    }
//
//    @Test
//    public void testFormatDateWithHour_G() {
//        IDateUtil dateUtil = new DateUtil();
//
//        Calendar c1 = new GregorianCalendar(2017,7,16,15,0,0);
//        String result1 = dateUtil.gFormatDate(c1.getTime());
//        Assert.assertEquals("16/08/2017 15:00",result1);
//
//        Calendar c2 = new GregorianCalendar(2027,8,30,15,0,0);
//        String result2 = dateUtil.gFormatDate(c2.getTime());
//        Assert.assertEquals("30/09/2027 15:00",result2);
//
//    }
//
//    @Test
//    public void testDateFromString_H() throws ParseException {
//        IDateUtil dateUtil = new DateUtil();
//
//        String s1 = "16/08/2017";
//        Calendar c1 = new GregorianCalendar(2017,7,16,0,0,0);
//        Date result1 = dateUtil.hDateFromString(s1);
//        Assert.assertEquals(c1.getTime(), result1);
//
//        String s2 = "30/09/2027";
//        Calendar c2 = new GregorianCalendar(2027,8,30,0,0,0);
//        Date result2 = dateUtil.hDateFromString(s2);
//        Assert.assertEquals(c2.getTime(),result2);
//    }
//
//    @Test
//    public void testDateFromString_I() throws ParseException {
//        IDateUtil dateUtil = new DateUtil();
//
//        String s1 = "16/08/2017 20:10";
//        Calendar c1 = new GregorianCalendar(2017,7,16,20,10, 0);
//        Date result1 = dateUtil.iDateFromString(s1);
//        Assert.assertEquals(c1.getTime(), result1);
//
//        String s2 = "30/09/2027 12:20";
//        Calendar c2 = new GregorianCalendar(2027,8,30,12,20,0);
//        Date result2 = dateUtil.iDateFromString(s2);
//        Assert.assertEquals(c2.getTime(),result2);
//    }



}
