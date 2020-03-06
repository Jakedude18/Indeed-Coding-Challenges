import java.io.File;
import java.util.Scanner;

public class album_length
{
    public static void main(String[] args) throws Exception
    {
        Scanner fromFile;
        fromFile = new Scanner(new File("album_length.dat"));

        int numberOfSongs = fromFile.nextInt();
        fromFile.nextLine();
        int minutes = 0;
        int seconds = 0;
        for(int x=0; x<numberOfSongs; x++)
        {
            String time = fromFile.nextLine().split(",")[1];

            minutes+=Integer.parseInt(time.substring(1,time.indexOf(":")));
            seconds+=Integer.parseInt(time.substring(time.indexOf(":")+1));
        }
        minutes+=seconds/60;
        seconds%=60;

        System.out.printf("The album length is %d:%s",minutes,((seconds<10)?"0":"")+seconds);
    }
}
