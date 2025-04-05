package RestaurantManagement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateMonthYear {

    public static Date setDate(int dd, int mm, int yyyy){
        yyyy -= 1990;
        Date date = new Date( yyyy, mm, dd);
        return date;
    }

    public static String DateToString (Date date){
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = df.format(date);

        return dateString;
    }

}
