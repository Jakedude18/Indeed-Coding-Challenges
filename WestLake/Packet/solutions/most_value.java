import java.io.File;
import java.util.Scanner;

public class most_value
{
    public static void main(String[] args) throws Exception
    {
        Scanner fromFile = new Scanner(new File("most_value.dat"));

        while(fromFile.hasNextLine()) {
            String[] textValues = fromFile.nextLine().split(" ");
            int[] values = new int[textValues.length];

            for(int x=0; x<values.length;x++)
                values[x]=Integer.parseInt(textValues[x]);


            int maxCount =numOccurrences(values[0],values);
            int maxValue = values[0];

            int total = values[0];
            for(int x=1; x<values.length; x++) {
                int count = numOccurrences(values[x],values);
                if(count > maxCount){
                    maxCount=count;
                    maxValue=values[x];
                }
                total+= values[x];
            }

            System.out.printf("%d accounts for %d of the sets total value of %d\n",maxValue,maxValue*maxCount,total);
        }
    }

    public static int numOccurrences(int v, int[] values)
    {
        int count=0;
        for(int value:values)
            if(value==v)
                count++;
        return count;
    }
}
