import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class TimeConversion {
    public static void main(String[] args)throws Exception{
        String time1 = "08 / 04 / 2020 17:15:00";
        String time2 = "08 / 04 / 2020 18:00:00";

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd / MM / yyy hh:mm:ss");
        System.out.println(format.format(calendar.getTime()));
        Date date1 = format.parse(time1);
        Date date2 = format.parse(time2);
        long difference = date2.getTime() - date1.getTime(); 
        long newdifference = difference - 2700000;
        System.out.println(difference);
        System.out.println(newdifference);
    }
}