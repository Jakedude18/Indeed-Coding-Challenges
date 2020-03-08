import java.util.*;
import java.io.*;

public class Boring {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("boring.dat"));
        int times = scan.nextInt();
        scan.nextLine();

        for (int x = 0; x < times; ++x) {
            String input = scan.nextLine();
            boolean res = false;
            for (String word : input.split(" ")) {
                if (word.toLowerCase().equals("boring") || word.toLowerCase().equals("space")) {
                    res = true;
                    break;
                }
            }
            System.out.println(res);
        }
        /*

        while (scan.hasNextLine())
        {

        }

        */
    }
}
