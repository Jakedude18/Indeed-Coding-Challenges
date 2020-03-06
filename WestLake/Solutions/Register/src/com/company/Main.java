package com.company;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        int[] values = {2000, 1000, 500, 100, 25, 10, 5, 1};

        Scanner dat = new Scanner(new File("register.dat"));
            while(dat.hasNextLine()){
                Scanner line = new Scanner(dat.nextLine());
                int total = (int) Math.round(line.nextDouble() * 100);
                int amount = 0;
                for(int i = 0; i < 8; i++){
                    amount += values[i] * line.nextInt();
                }
                if(total == amount){
                    System.out.println("Correct");
                }
                else if(amount < total){
                    System.out.printf("Missing $%.2f\n", (total - amount) / 100.0);
                }
                else
                    System.out.printf("Over $%.2f\n", (amount - total) / 100.0);
            }
    }
}
