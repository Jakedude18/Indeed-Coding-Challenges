import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.Pattern;


class recruit {
    int id;
    boolean cap;
    boolean returning;
    int[] connections;

    recruit(boolean cap, boolean returning, int[] connections) {
        this.cap = cap;
        this.returning = returning;
        this.connections = connections;
    }
}

public class Recruiting {


    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("file.dat"));
        int times = scan.nextInt();
        scan.nextLine();

        //Pattern par = new Pattern("*");

        for (int x = 0; x < times; ++x) {
            int numberOfRecruits = scan.nextInt();
            Map<Integer, Recruiting> recruits = new HashMap<>();
            for(int i = 0; i < numberOfRecruits; i++){
                String recruit = scan.nextLine();
                boolean cap;
                //boolean cap;
                //recruits.put()
            }
        }

        /*

        while (scan.hasNextLine())
        {

        }

        */
    }
}
