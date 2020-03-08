import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Phobos {
    static ArrayList<Character> CONSONANTS = new ArrayList<Character>();

    static Character vowels[] = {'A', 'E', 'I', 'O', 'U'};
    static ArrayList<Character> VOWELS = Arrays.asList();

    public static void shift(boolean phobos, char ch) {
        boolean vowel = VOWELS.contains(ch);

        if(phobos) {
            if(vowel) {
                int index = VOWELS.indexOf(ch);
                if(index==5) return vowels[0];
                else return vowels
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("phobos.dat"));
        int times = scan.nextInt();
        scan.nextLine();
        Character vowels[] = {'A', 'E', 'I', 'O', 'U'};
        for(int i = 0; i < vowels.length; ++i) VOWELS.add(vowels[i]);

        Boolean phobos;

        int num_vowels = 0;
        int letters = 0;
        for (int x = 0; x < times; ++x) {
            String[] line = scan.nextLine().split(" ");
            for(String c : line) {
                for(char letter : c.toCharArray()) {
                    letters++;
                    if (VOWELS.contains(letter))
                        num_vowels++;
                }
            }
            if((double)num_vowels/letters > 0.5) {
                phobos=true;
            }

            StringBuffer sb = new StringBuffer();
            sb.append(line);
            sb.reverse();



        }

        /*

        while (scan.hasNextLine())
        {

        }


    }
}
