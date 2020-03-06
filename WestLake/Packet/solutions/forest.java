import java.io.File;
import java.util.Scanner;

public class forest
{
    public static void main(String[] args) throws Exception
    {
        Scanner fromFile;
        fromFile = new Scanner(new File("forest.dat"));

        int[] treeHeight = new int[fromFile.nextInt()];
        int max =-1;
        for(int x=0; x<treeHeight.length;x++){
            treeHeight[x]=fromFile.nextInt();
            if(treeHeight[x] >max)
                max=treeHeight[x];
        }

        char[][] trees = new char[(max-1)*2+5][7*(treeHeight.length)];
        //System.out.println(trees[0].length);
        for(int rr=0; rr<trees.length;rr++)
            for(int cc=0; cc<trees[0].length; cc++)
                trees[rr][cc]=' ';

        for(int x=0; x<treeHeight.length;x++)
        {
            if(treeHeight[x]==0)
                continue;
            else{
                int y = trees.length-1;

                // trunk
                trees[y-1][x*7+2]=trees[y-1][x*7+3] =trees[y][x*7+2]=trees[y][x*7+3] = '|';

                y-=2;
                // non-top levels
                for(int a=1; a<treeHeight[x];a++) {
                    trees[y][x * 7] = '/';
                    trees[y][x * 7 + 1] = '_';
                    trees[y][x * 7 + 4] = '_';
                    trees[y][x * 7+5] = '\\';
                    y--;
                    trees[y][x * 7 + 1] = '/';
                    trees[y][x * 7+4] = '\\';
                    y--;
                }

                trees[y][x * 7] = '/';
                trees[y][x * 7 + 1] = '_';
                trees[y][x * 7 + 4] = '_';
                trees[y][x * 7+5] = '\\';
                y--;
                trees[y][x * 7 + 1] = '/';
                trees[y][x * 7+4] = '\\';
                y--;
                trees[y][x * 7 + 2] = '/';
                trees[y][x * 7+3] = '\\';

            }
        }

        for(int rr=0; rr<trees.length;rr++) {
            for (int cc = 0; cc < trees[0].length; cc++)
                System.out.print(trees[rr][cc]);
            System.out.println();
        }
    }
}
//   /\
//  /  \
// /_  _\
//  /  \
// /_  _\
//  /  \
// /_  _\
//  /  \
// /_  _\
//   ||
//   ||