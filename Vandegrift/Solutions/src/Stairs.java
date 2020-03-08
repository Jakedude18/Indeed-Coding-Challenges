import java.util.*;
import java.io.*;
import java.math.*;

public class Stairs {
     public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(new File("stairs.dat"));
        int times = scan.nextInt();
        scan.nextLine();

        for (int x = 0; x < times; ++x)
        {
            int stairs = scan.nextInt();
            String fortmat = (scan.next().equals("R")?"%":"%-") + stairs + "s\n";
            String type = scan.next();
            StringBuilder out = new StringBuilder();
            for(int i = 0; i < stairs; i ++){
                out.append(type);
                System.out.printf(fortmat, out);
            }
        }

        /*

        while (scan.hasNextLine())
        {

        }

        */
    }
}
