package UIL;

/**
 * Hello world!
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner dat = new Scanner(new File("chances.dat"));
        StringBuilder res = new StringBuilder();
        dat.nextInt();
        while(dat.hasNextDouble()){
            res.append(String.format("%.0f \n", dat.nextDouble()*dat.nextDouble()/100));
        }

        System.out.println(res);
    }
}