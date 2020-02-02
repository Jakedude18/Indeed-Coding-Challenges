import java.util.Scanner;
import java.util.Stack;

public class Graph {
    private int[] rowV = {1,-1,0,0};
    private int[] colV = {0,0,1,-1};
    private String[][] graph;
    private int rows, cols;
    private boolean[][] visited;
    private Point start;
    private Point end;

    Graph(Scanner dat, int rows, int cols){
        graph = new String[rows][];

        this.rows = rows;
        this.cols = cols;

        //assign values graph

        //move to first line of graph in scanner
        dat.nextLine();

        for(int i = 0; i < rows; i++){
            graph[i] = dat.nextLine().split("");
        }
        for(String[] row : graph){
            for(String str : row)
                System.out.print(str);
            System.out.println();
        }
        end = new Point(dat.nextInt(), dat.nextInt());
        start = new Point(dat.nextInt(), dat.nextInt());

        visited = new boolean[rows][cols];
    }

    String DFS(){
        Stack<Point> stack = new Stack<Point>();
        stack.add(start);
        while(!stack.isEmpty()) {
            Point pos = stack.pop();
            if (pos.equals(end))
                return "Escaped";
            visited[pos.row][pos.col] = true;
            for (int i = 0; i < 4; i++) {
                int transRow = pos.row + rowV[i];
                int transCol = pos.col + colV[i];
                //check in bounds
                if (transRow >= rows || transRow < 0 || transCol >= cols || transCol < 0)
                    continue;
                if (graph[transRow][transCol].equals("#"))
                    continue;
                if (visited[transRow][transCol])
                    continue;
                stack.push(new Point(transRow, transCol));
            }
        }
        return "Trapped";
    }
}
