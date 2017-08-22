import java.text.*;
import java.util.*;



public class DateUtil implements IDateUtil {

    @Override
    public int aCompareDate(Date d1, Date d2) {
        //SimpleDateFormat df = new SimpleDateFormat(dateFormat1);
        //System.out.print(df.format(d1)+" is ");
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

        Calendar c = Calendar.getInstance();
        System.out.println(c.getTime());
        SimpleDateFormat x = new SimpleDateFormat(dateFormat1);
        Date d1 = new Date();
        Date d2 = new Date();
        d1.setTime(1112121111);
        d2.setTime(1212121112);

        System.out.println(x.format(d1));
        IDateUtil DateUtil = new DateUtil();
        DateUtil.aCompareDate(d1,d2);
        //Calendar c1 = Calendar.getInstance();
        //Calendar c2 = Calendar.getInstance();
        //c1.setTime(d1);
        //c2.setTime(d2);

        //if(c2.before(c1))
        //    System.out.println("less than "+x.format(d2));

        System.out.println(DateUtil.bCompareDate(d1,d2));
        long diff = d2.getTime() - d1.getTime();

        System.out.println( (diff/(24*3600*1000)));




        System.out.println("sdfsdf " + DateUtil.cDaysbtwDates(d1,d2) );

        System.out.println("3. No of Days between 2 dates\n");
        Calendar c1 = Calendar.getInstance(); 	//new GregorianCalendar();
        Calendar c2 = Calendar.getInstance(); 	//new GregorianCalendar();
        c1.set(1999, 0 , 20);
        c2.set(1999, 0 , 22);
        c1.setTime(d1);
        c2.setTime(d2);
        c1.set(Calendar.HOUR_OF_DAY,0);
        c1.set(Calendar.MINUTE, 42);
        c1.set(Calendar.SECOND,0);
        //c2.set(c2.HOUR_OF_DAY,0);

        System.out.println("Days Between "+c1.getTime()+" and "+ c2.getTime()+" is");
        System.out.println((c2.getTime().getTime() - c1.getTime().getTime())/(24*3600*1000));
        System.out.println(DateUtil.iDateFromString("32/02/1996 12:22"));
        System.out.println(DateUtil.gFormatDate(d1));
        System.out.println(d1);
        System.out.println(DateUtil.dDayAfter(d1, 25));



    }

}

