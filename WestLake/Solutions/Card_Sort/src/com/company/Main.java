package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Card implements Comparable<Card> {
        private String name;
        int attack;
        int defense;
        int power;

        Card(String n, int a, int d) {
            name = n;
            attack = a;
            defense = d;
            power = a + d;
        }

        @Override
        public int compareTo(Card o) {
            if (o.power != power)
                return o.power - power;
            else if (attack != o.attack)
                return o.attack - attack;
            else
                return name.compareTo(o.name);
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner dat = new Scanner(new File("card_sort.dat"));
        List<Card> deck = new ArrayList<>();
        while (dat.hasNextLine()) {
            Scanner line = new Scanner(dat.nextLine());
            while (line.hasNext()) {
                String[] fields = line.next().split("/");
                deck.add(new Card(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2])));
            }
        }
        Collections.sort(deck);
        deck.stream().map(s -> s.name).forEach(System.out::println);
    }
}
