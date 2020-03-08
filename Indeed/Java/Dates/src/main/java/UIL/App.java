package UIL;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class App {

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");


    public static void main(String[] args) throws Exception {
        Scanner dat = new Scanner(new File("dates.dat"));
        int count = dat.nextInt();
        dat.nextLine();
        for(int i = 0; i < count; i++) {

            Date currentDate = dateFormat.parse(dat.nextLine());

            // convert date to calendar
            Calendar c = Calendar.getInstance();
            c.setTime(currentDate);

            //change the calendar date
            c.add(Calendar.DATE,dat.nextInt());

            // convert calendar to date
            Date currentDatePlusOne = c.getTime();

            System.out.println(dateFormat.format(currentDatePlusOne));
            //move to next line on scanner
            if(i < count - 1)
                dat.nextLine();
        }
    }
}
