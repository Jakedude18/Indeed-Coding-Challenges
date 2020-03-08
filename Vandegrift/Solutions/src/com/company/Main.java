package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("dryrun.dat"));
        int times = scan.nextInt();
        scan.nextLine();

        for (int x = 0; x < times; ++x) {
            System.out.println("I like " + scan.next() + ".");
        }

        /*

        while (scan.hasNextLine())
        {

        }

        */
    }
}
