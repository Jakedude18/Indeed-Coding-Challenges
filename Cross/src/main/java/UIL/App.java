package UIL;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException
    {
        Scanner dat = new Scanner(new File("cross.dat"));
        int count = dat.nextInt();
        for(int i = 0; i < count; i++){
            String hor = dat.next();
            dat.next();
            String ver = dat.next();
            int indexHor = -1;
            int indexVer = -1;
            char[] verChars = ver.toCharArray();
            char[] horChars = hor.toCharArray();
            for(int j = 0; j < hor.length(); j++){
                for(int k = 0; k < ver.length(); k++){
                    if(horChars[j] == verChars[k]){
                        indexHor = j;
                        indexVer = k;
                        break;
                    }
                }
            }
            if(indexHor == -1)
                continue;
            for(int j = 0; j < ver.length(); j++){
                for(int k = 0; k < hor.length(); k++){
                    if(j == indexVer){
                        System.out.print(hor);
                        break;
                    }
                    if(k == indexHor){
                        System.out.print(verChars[j]);
                    }
                    else
                        System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
