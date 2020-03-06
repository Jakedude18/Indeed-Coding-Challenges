package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner dat = new Scanner(new File("octagon.dat"));
        int count = dat.nextInt();
        for(int i = 0; i < count; i++){
            System.out.printf("%.2f\n", Math.sqrt(dat.nextDouble() / (2 * (1 + Math.sqrt(2)))));
        }
    }
}
