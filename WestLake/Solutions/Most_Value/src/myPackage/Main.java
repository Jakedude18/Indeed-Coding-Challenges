package myPackage;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner dat = new Scanner(new File("most_value.dat"));
        while(dat.hasNextLine()){
            Map<Integer, Integer> freq = new HashMap<>();
            Scanner line = new Scanner(dat.nextLine());
            Integer highest = null;
            int total = 0;
            while (line.hasNextInt()){
                int next = line.nextInt();
                total += next;
                if(!freq.containsKey(next))
                    freq.put(next, 1);
                else
                    freq.replace(next, freq.get(next) + 1);
                if(highest == null || freq.get(next) > freq.get(highest))
                    highest = next;
            }

            System.out.printf("%d accounts for %d of the sets total value of %d\n", highest, highest * freq.get(highest), total);
        }
    }
}
