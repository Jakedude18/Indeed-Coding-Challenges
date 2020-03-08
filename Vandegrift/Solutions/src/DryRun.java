import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DryRun {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("dryrun.dat"));
        int times = scan.nextInt();
        scan.nextLine();

        for (int x = 0; x < times; ++x) {
            System.out.println("I like " + scan.nextLine() + ".");
        }

        /*

        while (scan.hasNextLine())
        {

        }

        */
    }
}
