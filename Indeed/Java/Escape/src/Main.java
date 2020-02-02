import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        Scanner dat = new Scanner(new File("escape.dat"));
        int count = dat.nextInt();
        for(int j = 0; j < count; j++){
            Graph graph = new Graph(dat, dat.nextInt(), dat.nextInt());
            System.out.println(graph.DFS());
        }
    }
}
