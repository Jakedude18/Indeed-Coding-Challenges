import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Potatoes {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("potatoes.dat"));
        int times = scan.nextInt();
        scan.nextLine();

        for (int x = 0; x < times; ++x) {
            double f = Double.parseDouble(scan.nextLine());
            double c = (f-32) * 5.0/9;
            double ideal_c = (70.0-32.0)*5.0/9;

            double diff = ideal_c - c;
            if(diff==0) System.out.print("No change");
            else {
                System.out.printf("%.2f", Math.abs(diff));
                if(diff>0) System.out.print(" degrees warmer");
                if(diff<0) System.out.print(" degrees cooler");

            }
            System.out.println();





        }

        /*

        while (scan.hasNextLine())
        {

        }

        */
    }
}
