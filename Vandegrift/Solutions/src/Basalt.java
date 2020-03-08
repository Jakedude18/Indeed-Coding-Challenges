import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Basalt {
     public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(new File("basalt.dat"));
        int times = scan.nextInt();
        scan.nextLine();

        double highest, lowest;
        highest = Double.MIN_VALUE;
        lowest = Double.MAX_VALUE;


        for (int x = 0; x < times; ++x)
        {
            double next = scan.nextDouble();
            if(next > highest)
                highest = next;
            if(next < lowest)
                lowest = next;
        }

        System.out.println(lowest);
        System.out.println(highest);


        /*



        }

        */
    }
}
