package com.company;

import java.util.*;

public class DFS {
    //orthographical movement
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, 1, -1};

    private char[][] map;
    private boolean[][] depthBoard;

    private Point start, end;

    private int rows,cols;

    MapParser(Scanner dat, int rows, int columns) {
        Scanner maze = new Scanner(dat.next());
        map =  new char[rows][columns];
        this.rows = rows;
        this.cols = columns;
        depthBoard =  new boolean[rows][columns]
        for (int j = 0; j < rows; j++) {
            map[j] = maze.nextLine().toCharArray();
            //check for start
            for (int k = 0; k < columns; k++) {
                if (map[j][k] == 'S') {
                    start = new Point(j, k);
                }
                if (map[j][k] == 'E') {
                    end = new Point(j, k);
                }
            }
        }
    }

    public boolean DFS() {
        Stack<Point> stack = new Stack();
        stack.push(start);
        while (!stack.empty()) {
            Point point = stack.pop();
            if(point.equals(end))
                return true;
            for(Point nextPoint : search(point)){
                stack.push(nextPoint);
            }
        }
        return false;
    }

    private List<Point> search(Point point) {
        List<Point> neighbors = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Point nextPoint = new Point(point.row + dr[i], point.col + dc[i]);
            if (inBounds(nextPoint) && !visited(nextPoint) && !wall(nextPoint)) {
                visit(nextPoint);
                neighbors.add(nextPoint);
            }
        }
        return neighbors;
    }

    private boolean inBounds(Point point) {
        if (point.row < 0 || point.row >= rows)
            return false;
        if (point.col < 0 || point.col >= cols)
            return false;
        return true;
    }

    private boolean visited(Point point) {
        return depthBoard[point.row][point.col];
    }

    private boolean wall(Point point) {
        return map[point.row][point.col] == 'W';
    }

    private void visit(Point point) {
        depthBoard[point.row][point.col] = true;
    }

    public void printBoard() {
        for (boolean[] row : depthBoard) {
            for (boolean bool : row)
                System.out.print(bool ? "T" : "F");
            System.out.println();
        }
    }
}
