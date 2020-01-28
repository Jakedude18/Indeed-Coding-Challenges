package UIL;

import java.util.Scanner;

class MapParser {



    private String[][] map;
    private boolean[][] breathBoard;
    private Point start;
    private Point end;

    private int startPower;

    MapParser(Scanner dat) {
        map = new String[10][10];
        breathBoard = new boolean[10][10];
        //instantiate breathBoard
        for (boolean[] row : breathBoard) {
            for (int i = 0; i < 10; i++) {
                row[i] = false;
            }
        }
        //instantiate map
        for (int j = 0; j < 10; j++) {
            String line = dat.nextLine();
            map[j] = line.split("");
            //find start
            for (int k = 0; k < map[j].length; k++) {
                if (map[j][k].equals("S"))
                    start = new Point(j, k);
                else if(map[j][k].equals("E")){
                    end = new Point(j, k);
                }
            }
        }
        startPower = dat.nextInt();
    }

    int getTileValue(int row, int col) {
        if(row >= map.length || col >= map.length) return 0;
        if(row < 0 || col < 0) return 0;
        if(map[row][col].equals("X")) return 0;
        if(breathBoard[row][col]) return 0;
        breathBoard[row][col] = true;
        return map[row][col].equals("*")?5:1;
    }

    boolean[][] getBreathBoard() {
        return breathBoard;
    }

    Point getStart() {
        return start;
    }

    Point getEnd() {
        return end;
    }

    int getStartPower() {
        return startPower;
    }
}
