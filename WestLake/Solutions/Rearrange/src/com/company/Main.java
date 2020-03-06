package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner dat = new Scanner(new File("rearrange.dat"));
        while(dat.hasNextLine()){
            String[] words = dat.nextLine().split(" ");
            for(String word : words){
                if(word.length() <= 2){
                    System.out.print(word + " ");
                }
                else{
                    StringBuilder encr = new StringBuilder(word);
                    int len = word.length();
                    if(word.length() % 2 == 1){
                        encr.replace(0,1, word.substring(len - 1, len));
                        encr.replace(len - 1, len, word.substring(0,1));
                    }
                    else{
                        encr.replace(0,1, word.substring(len/2 - 1, len/2));
                        encr.replace(len/2 - 1, len/2, word.substring(0,1));
                        encr.replace(len/2, len/2 + 1, word.substring(len - 1, len));
                        encr.replace(len - 1, len, word.substring(len/2, len/2 + 1));
                    }
                    System.out.print(encr + " ");
                }
            }
            System.out.println();
        }
    }
}
