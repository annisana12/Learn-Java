package application;

import java.util.Calendar;
import java.util.Date;

public class DateCalendarApp {
    public static void main(String[] args) {
        /**
         * Banyak constructor yang sudah deprecated
         * Tersisa constructor tanpa parameter (return current date and time)
         * Juga constructor dengan parameter milisecond dengan tipe data long
         */
        Date today = new Date();
        Date yesterday = new Date(1701696840000L);

        System.out.println(today);
        System.out.println(yesterday);

        // Class Calendar untuk memanipulasi date
        Calendar calendar = Calendar.getInstance(); // current date
        calendar.set(Calendar.YEAR, 2022);
        calendar.add(Calendar.YEAR, -10);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 12);
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date result = calendar.getTime();
        System.out.println(result);
    }
}
