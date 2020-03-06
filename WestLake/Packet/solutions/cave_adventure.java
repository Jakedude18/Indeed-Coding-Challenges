import java.util.*;
import java.io.*;
public class cave_adventure
{
    private static char[][] cave;
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception
    {
        Scanner fromFile = new Scanner(new File("cave_adventure.dat"));

        while(fromFile.hasNextLine()) {
            visited = new boolean[8][8];
            cave = new char[8][8];
            int startRow = 0, startCol = 0;
            int endRow = 0, endCol = 0;
            for (int row = 0; row < cave.length; row++) {
                String s = fromFile.nextLine();

                for (int col = 0; col < cave[0].length; col++) {
                    cave[row][col] = s.charAt(col);
                    if (cave[row][col] == 'S') {
                        startRow = row;
                        startCol = col;
                    }
                    if (cave[row][col] == 'E') {
                        endRow = row;
                        endCol = col;
                    }
                }
            }

            markVisited(startCol, startRow);

            System.out.println((visited[endRow][endCol])?"Solvable":"No Solution");

            if(fromFile.hasNextLine())
                fromFile.nextLine();
        }

    }

    public static void markVisited(int col,int row) {
        if (row < 0 || row >= visited.length || col < 0 || col >= visited[0].length
                || visited[row][col] || cave[row][col] == 'W' || cave[row][col] == 'G')
            return;

        visited[row][col] = true;
        markVisited(col + 1, row);
        markVisited(col - 1, row);
        markVisited(col, row + 1);
        markVisited(col, row - 1);

        //jumps
        if (col + 2 < visited[0].length && cave[row][col+1] == 'G')
            markVisited(col + 2, row );
        if (col - 2 >= 0 && cave[row][col-1] == 'G')
            markVisited(col - 2, row);
        if (row + 2 < visited.length && cave[row+1][col] == 'G')
            markVisited(col, row + 2);
        if (row - 2 >= 0 && cave[row-1][col] == 'G')
            markVisited(col, row - 2);
    }
}