package UIL;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException
    {
        Scanner dat = new Scanner(new File("profit.dat"));
        NumberFormat nm = NumberFormat.getCurrencyInstance();
        StringBuilder res = new StringBuilder("      Price     *       Tax      *     Profit     *\n");
        StringBuilder delimiter = new StringBuilder();
        for(int i = 0; i < 51; i++)
            delimiter.append("*");
        delimiter.append("\n");
        res.append(delimiter);
        int count = dat.nextInt();
        double tax =  dat.nextInt();
        double totalS,totalT,totalP;
        totalS = totalT = totalP = 0;
        for(int i = 0; i < count; i++){
            int steal = dat.nextInt();
            double gov = steal/tax;
            double profit = steal - gov;
            totalS += steal;
            totalT += gov;
            totalP += profit;
            res.append(String.format("%15s *%15s *%15s *\n",nm.format(steal),nm.format(gov),nm.format(profit)));
        }
        res.append(delimiter);
        res.append(String.format("%15s *%15s *%15s *",nm.format(totalS),nm.format(totalT),nm.format(totalP)));
        System.out.println(res);


    }
}
