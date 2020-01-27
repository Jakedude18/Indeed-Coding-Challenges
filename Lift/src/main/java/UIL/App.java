package UIL;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws FileNotFoundException {

        class Item implements Comparable{
            double weight;
            double value;
            double density;

            Item(double value, double weight){
                this.weight = weight;
                this.value = value;
                this.density = weight/value;
            }

            public int compareTo(Object o) {
                Item item = (Item)o;
                if(density > item.density) return 1;
                if(density < item.density) return -1;
                return 0;
            }

            public String toString(){
                return "weight:" + weight + " value:" + value;
            }
            }
            class CalcValue{
                List<Item> items;
                CalcValue(List<Item> items){
                    this.items = items;
                }

                double calcValue(double cap){
                    if (cap == 0){
                        return 0;
                    }
                    Item best = items.get(0);
                    items.remove(best);
                    if (best.weight <= cap){
                        return calcValue(cap - best.weight) + best.value;
                    }
                    return calcValue(0) + best.value * (cap/best.weight);
                }
            }


        Scanner dat = new Scanner(new File("lift.dat"));
        StringBuilder res = new StringBuilder();
        int setCnt = dat.nextInt();
        for(int i = 0; i < setCnt; i++){
            dat.nextInt();
            dat.nextLine();
            List<Item> items = new ArrayList<Item>();
            Scanner line1 = new Scanner(dat.nextLine());
            Scanner line2 = new Scanner(dat.nextLine());
            while(line1.hasNext()){
                items.add(new Item(line2.nextDouble(),line1.nextDouble()));
            }
            NumberFormat nm = NumberFormat.getCurrencyInstance();
            int cap = dat.nextInt();
            Collections.sort(items);
            CalcValue calcValue = new CalcValue(items);
            res.append(nm.format(calcValue.calcValue(cap)) + (i != setCnt?"\n": ""));
        }
        System.out.println(res);
    }
}