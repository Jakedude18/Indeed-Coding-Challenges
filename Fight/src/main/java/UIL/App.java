package UIL;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException
    {
        Scanner dat = new Scanner(new File("fight.dat"));
        while(dat.hasNextLine()) {
            int thor = 200;
            int noobSlayer69 = 200;
            Random ran = new Random(dat.nextInt());
            //true = thor
            //false = noobSlayer69
            boolean priority = true;
            while((priority?thor : noobSlayer69) > 0){
                if(priority)
                    noobSlayer69 -= ran.nextInt(200);
                else
                    thor -= ran.nextInt(200);
                priority = !priority;
            }
            System.out.println((noobSlayer69 <= 0?"Thor" : "NoobSlayer69") + " wins!");
        }
    }
}
