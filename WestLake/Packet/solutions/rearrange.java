import java.io.File;
import java.util.Scanner;

public class rearrange
{
    public static void main(String[] args) throws Exception
    {
        Scanner fromFile;
        fromFile = new Scanner(new File("rearrange.dat"));

        while(fromFile.hasNextLine())
        {
            String[] words = fromFile.nextLine().split(" ");
            String result = "";
            for(String s:words)
            {
                if(s.length()<=2)
                    result+=s+ " ";
                else
                {
                    if(s.length()%2==0)
                        result += s.charAt(s.length()/2-1)+s.substring(1,s.length()/2-1)+s.charAt(0)+
                                s.charAt(s.length()-1)+ s.substring(s.length()/2+1,s.length()-1) +s.charAt(s.length()/2) + " ";
                    else
                        result+=s.charAt(s.length()-1) + s.substring(1, s.length()-1) + s.charAt(0) + " ";
                }
            }
            System.out.println(result.trim());
        }
    }
}
