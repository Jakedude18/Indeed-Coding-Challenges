import java.io.File;
import java.util.Scanner;

public class register
{
    public static void main(String[] args) throws Exception
    {
        Scanner fromFile;
        fromFile = new Scanner(new File("register.dat"));

        for(int x=0; x<3; x++)
        {
            double expected = fromFile.nextDouble();

            double actual = fromFile.nextInt() * 20 +
                    fromFile.nextInt() * 10 +
                    fromFile.nextInt() * 5 +
                    fromFile.nextInt() * 1 +
                    fromFile.nextInt() * .25 +
                    fromFile.nextInt() * .10 +
                    fromFile.nextInt() * .05 +
                    fromFile.nextInt() * .01;

            if (Math.abs(expected - actual) < .01)
                System.out.println("Correct");
            else if(actual < expected)
                System.out.printf("Missing $%.2f\n",expected-actual);
            else
                System.out.printf("Over $%.2f\n",actual-expected);
        }
    }
}
