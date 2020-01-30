package UIL;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Hello world!
 */

public class App {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner dat = new Scanner(new File("blast.dat"));
        Queue<RoboInst> rq = new LinkedList<RoboInst>()                                                                                                                                                                               ;
        MapParser map = new MapParser(dat);
        //breath first search
        boolean escaped = false;
        rq.add(new RoboInst(map.getStartPower(), map.getStart().row, map.getStart().col));
        while(!rq.isEmpty()){
            RoboInst robot = rq.poll();
            //check if at end of maze
            if(robot.getPos().equals(map.getEnd())){
                escaped = true;
                break;
            }
            rq.addAll(robot.search(map));
        }
        System.out.println(escaped?"Escaped!":"Impossible");

        for(boolean[] row : map.getBreathBoard()){
            for(boolean val : row){
                System.out.print(val?1:0);
            }
            System.out.println();
        }
    }
}
