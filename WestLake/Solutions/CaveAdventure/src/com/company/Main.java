package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner dat = new Scanner(new File("cave_adventure.dat")).useDelimiter("\r\n-\r\n");
        while (dat.hasNext()) {
            MapParser map = new MapParser(dat);
            System.out.println(map.DFS() ? "Solvable" : "No Solution");
            map.printBoard();
        }

    }
}
