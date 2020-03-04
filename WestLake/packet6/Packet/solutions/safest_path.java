import java.util.*;
import java.io.*;
public class safest_path
{
    private static char[][] map;
    private static int[][] distance;

    public static void main(String[] args) throws Exception
    {
        Scanner fromFile = new Scanner(new File("safest_path.dat"));

        while(fromFile.hasNextLine())
        {
            map = new char[8][8];
            distance = new int[8][8];
            int startCol=0, startRow=0,endCol=0, endRow=0;

            for(int row = 0; row< map.length; row++)
            {
                String s = fromFile.nextLine();

                for(int col = 0; col< map[0].length; col++)
                {
                    map[row][col] = s.charAt(col);
                    distance[row][col] = -1;
                    if(map[row][col]=='S')
                    {
                        startRow=row;
                        startCol=col;
                    }
                    if(map[row][col]=='E')
                    {
                        endRow=row;
                        endCol=col;
                    }
                }
            }
            distance[startRow][startCol] = 0;
            int x=0;
            while(!markDistances(x++));

            System.out.println(distance[endRow][endCol]);

            //printDistances();
            if(fromFile.hasNextLine())
                fromFile.nextLine();
        }
    }

    public static boolean markDistances(int dist)
    {
        boolean done=true;
        for(int row = 0; row< map.length; row++)
        {
            for(int col = 0; col< map[0].length; col++)
            {
                boolean reset=false;
                if(distance[row][col]>=dist)
                    done=false;
                if(distance[row][col]==dist)
                {
                    done=false;

                    //up
                    if(row-1 >=0)
                    {
                        if(map[row-1][col]=='E' )
                            reset |= updateCell(col,row-1,distance[row][col]);
                        else if(map[row-1][col]=='R')
                            reset |= updateCell(col,row-1,distance[row][col]+1);
                        else if(map[row-1][col]=='B')
                            reset |= updateCell(col,row-1,distance[row][col]+2);
                        else if(map[row-1][col]=='W')
                            reset |= updateCell(col,row-1,distance[row][col]+4);
                        else if(map[row-1][col]=='G')
                            reset |= updateCell(col,row-1,distance[row][col]+5);
                        else if(map[row-1][col]=='T')
                            reset |= updateCell(col,row-1,distance[row][col]+9);

                    }

                    // left
                    if(col-1 >=0)
                    {
                        if(map[row][col-1]=='E' )
                            reset |= updateCell(col-1,row,distance[row][col]);
                        else if(map[row][col-1]=='R')
                            reset |= updateCell(col-1,row,distance[row][col]+1);
                        else if(map[row][col-1]=='B')
                            reset |= updateCell(col-1,row,distance[row][col]+2);
                        else if(map[row][col-1]=='W')
                            reset |= updateCell(col-1,row,distance[row][col]+4);
                        else if(map[row][col-1]=='G')
                            reset |= updateCell(col-1,row,distance[row][col]+5);
                        else if(map[row][col-1]=='T')
                            reset |= updateCell(col-1,row,distance[row][col]+9);
                    }

                    // down
                    if(row+1 < map.length)
                    {
                        if(map[row+1][col]=='E' )
                            reset |= updateCell(col,row+1,distance[row][col]);
                        else if(map[row+1][col]=='R')
                            reset |= updateCell(col,row+1,distance[row][col]+1);
                        else if(map[row+1][col]=='B')
                            reset |= updateCell(col,row+1,distance[row][col]+2);
                        else if(map[row+1][col]=='W')
                            reset |= updateCell(col,row+1,distance[row][col]+4);
                        else if(map[row+1][col]=='G')
                            reset |= updateCell(col,row+1,distance[row][col]+5);
                        else if(map[row+1][col]=='T')
                            reset |= updateCell(col,row+1,distance[row][col]+9);
                    }

                    // right
                    if(col+1 < map[0].length)
                    {
                        if(map[row][col+1]=='E' )
                            reset |= updateCell(col+1,row,distance[row][col]);
                        else if(map[row][col+1]=='R')
                            reset |= updateCell(col+1,row,distance[row][col]+1);
                        else if(map[row][col+1]=='B')
                            reset |= updateCell(col+1,row,distance[row][col]+2);
                        else if(map[row][col+1]=='W')
                            reset |= updateCell(col+1,row,distance[row][col]+4);
                        else if(map[row][col+1]=='G')
                            reset |= updateCell(col+1,row,distance[row][col]+5);
                        else if(map[row][col+1]=='T')
                            reset |= updateCell(col+1,row,distance[row][col]+9);
                    }
                    if(reset)
                    {
                        row=0;
                        col=-1;
                    }
                }
            }
        }
        return done;
    }

    public static void printDistances()
    {
        for(int[] row: distance)
        {
            for(int x: row)
                System.out.printf("%-4d",x);
            System.out.println();
        }
    }

    public static boolean updateCell(int col, int row, int value)
    {
        if(distance[row][col]==-1 || value < distance[row][col]) {
            distance[row][col] = value;
            return true;
        }
        return false;
    }
}