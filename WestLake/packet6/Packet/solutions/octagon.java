import java.io.File;
import java.util.Scanner;

public class octagon
{
    public static void main(String[] args) throws Exception
    {
        Scanner fromFile;
        fromFile = new Scanner(new File("octagon.dat"));

        int numOct = fromFile.nextInt();

        for(int x=0; x<numOct; x++) {
            double a = fromFile.nextDouble();
            double s = Math.sqrt(a/(2*(1+Math.sqrt(2))));
            System.out.printf("%.2f\n",s);
        }
    }
}
