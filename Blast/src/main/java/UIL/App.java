package UIL;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Queue;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Hello world!
 */

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        //tree
        //adding some code
        class Node {
            private Node parent = null;
            private int val;

            public Node(int data) {
                this.val = data;
            }


            public void setParent(Node parent) {
                this.parent = parent;
            }

            public Node addChild(int data) {
                Node child = new Node(data);
                child.setParent(this);
                return child;
            }
        }


        Scanner dat = new Scanner(new File("blast.dat"));
        Node lastNode = new Node(0);
        Node child = null;
        String[][] board = new String[10][10];
        Queue<Integer> rq = new LinkedList(), cq = new LinkedList();
        Point start = null;
        final int[] dr = {-1, 1, 0, 0};
        final int[] dc = {0, 0, 1, -1};
        boolean[][] breathBoard = new boolean[10][10];
        boolean reachedEnd = false;
        int power, nodesLeftInLayer, nodesInNextLayer;
        nodesLeftInLayer = 1;
        power = nodesInNextLayer = 0;

        //initialize breathBoard
        for (boolean[] row : breathBoard) {
            for (int i = 0; i < 10; i++) {
                row[i] = false;
            }
        }
        //create board
        for (int i = 0; dat.hasNextLine(); i++) {
            String line = dat.next();
            if (Pattern.matches("[0-9]+", line)) {
                power = Integer.valueOf(line);
            } else {
                board[i] = line.split("");
                //find start
                for (int k = 0; k < board[i].length; k++) {
                    if (board[i][k].equals("S"))
                        start = new Point(k, i);
                }
            }
        }
        rq.add(start.x);
        cq.add(start.y);
        breathBoard[start.x][start.y] = true;

        //solve
        while (rq.size() > 0) {
            int r = rq.poll();
            int c = cq.poll();
            if (board[r][c].equals("E")) {
                //check if ironman has enough power
                int total = 0;
                Node currentNode = lastNode;
                while (currentNode != null) {
                    total += currentNode.val;
                    currentNode = currentNode.parent;
                }
                if (total <= power) {
                    reachedEnd = true;
                    break;
                }
                continue;
            }

            //explore neighbors
            for (int i = 0; i < 4; i++) {
                int rr = r + dr[i];
                int cc = c + dc[i];

                //Skip out of bounds exception
                if (rr < 0 || cc < 0) continue;
                if (rr >= 10 || cc >= 10) continue;

                //Skip visited locations or blocked cells
                if (breathBoard[rr][cc]) continue;
                if (board[rr][cc].equals("X")) continue;

                rq.add(rr);
                cq.add(cc);
                child = lastNode.addChild(board[r][c].equals("*") ? 5 : 1);
                breathBoard[rr][cc] = true;
                nodesInNextLayer++;
            }

            //get ready for next iteration
            nodesLeftInLayer--;
            if (nodesLeftInLayer == 0) {
                nodesLeftInLayer = nodesInNextLayer;
                nodesInNextLayer = 0;
            }

        }
        for (boolean[] row : breathBoard) {
            for (boolean val : row) {
                System.out.print(val ? 0 : 1);
            }
            System.out.println();
        }
        System.out.println(reachedEnd);
    }
}
