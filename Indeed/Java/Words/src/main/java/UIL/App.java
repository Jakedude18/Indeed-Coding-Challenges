package UIL;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner dat = new Scanner(new File("words.dat"));
        String[] comp = dat.nextLine().replaceAll("[0-9]", "").split(" |(?=(?<=[^!?.])[?!.])");
        StringBuilder res = new StringBuilder();
        for(int j = 0; j < comp.length; j++){
            if(comp[j].matches("[?!.]+")) {
                res.append(comp[j]);
                continue;
            }
            if(j != 0)
                res.append(" ");
            char[] chars = comp[j].toCharArray();
            for(int k = 1; k <= chars.length; k++){
                res.append(chars[chars.length - k]);
            }

        }
        System.out.println(res);
    }
}
