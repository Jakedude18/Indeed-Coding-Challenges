import java.util.*;
import java.awt.*;
import java.io.*;
import java.text.DecimalFormat;

public class lost_city
{
    public static void main(String[] args) throws Exception
    {
        Scanner fromFile = new Scanner(new File("lost_city.dat"));


        while(fromFile.hasNextLine())
        {
            String[] data = fromFile.nextLine().split("-");
            int maxWeight = Integer.parseInt(data[0]);

            ArrayList<Item> items = new ArrayList<>();

            String[] textItems = data[1].split("/");

            for(int x=0; x<textItems.length; x++)
            {
                String[] itemValues = textItems[x].split(":");
                items.add(new Item(Integer.parseInt(itemValues[0]),Double.parseDouble(itemValues[1])));
            }
            System.out.printf("You grabbed $%.2f worth of artifacts.\n",maxCash(items,0,0,maxWeight));
        }
    }

    public static double maxCash(ArrayList<Item> items, int currentWeight, double currentValue, int maxWeight)
    {
        double maxValue = 0;
        for(int x=0; x<items.size(); x++)
        {
            if(currentWeight+items.get(x).weight <= maxWeight) {
                ArrayList<Item> itemsLeft = (ArrayList<Item>) items.clone();
                itemsLeft.remove(x);
                double value = maxCash(itemsLeft, currentWeight + items.get(x).weight,
                        currentValue+items.get(x).value, maxWeight);
                if (value > maxValue)
                    maxValue = value;
            }
        }

        return Math.max(maxValue,currentValue);
    }
}

class Item
{
    public int weight;
    public double value;

    public Item(int weight, double value) {
        this.weight = weight;
        this.value = value;
    }
}