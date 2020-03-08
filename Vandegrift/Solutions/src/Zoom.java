import java.util.*;
import java.io.*;
import java.math.*;

public class Zoom
{
    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(new File("zoom.dat"));
        int times = scan.nextInt();
        scan.nextLine();

        for (int x = 0; x < times; ++x)
        {
            int n = scan.nextInt();
            int[][] m = new int[n][n];

            for (int r = 0; r < n; ++r)
            {
                for (int c = 0; c < n; ++c)
                    m[r][c] = scan.nextInt();
            }

            int[][] result = new int[n / 2][n / 2];

            for (int r = 0; r < n; r += 2)
            {
                for (int c = 0; c < n; c += 2) {
                    long sum = m[r][c] + m[r+1][c] + m[r][c+1] + m[r+1][c+1];
                    result[r/2][c/2] = (int)Math.round(sum/4.0);
                }
            }

            for (int r = 0; r < n / 2; ++r)
            {
                String line = "";

                for (int c = 0; c < n / 2; ++c)
                {
                    line += result[r][c] + " ";
                }

                System.out.println(line.trim());
            }

            if (x != times - 1)
                System.out.println();
        }

        /*

        while (scan.hasNextLine())
        {

        }

        */
    }
}
