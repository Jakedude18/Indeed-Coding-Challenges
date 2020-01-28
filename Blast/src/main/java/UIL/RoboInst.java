package UIL;


import java.util.LinkedList;
import java.util.Queue;

class RoboInst {
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, 1, -1};
    private int power;
    private Point pos;



    RoboInst(int power, int row, int col){
        this.power = power;
        this.pos = new Point(row,col);
    }

    Point getPos() {
        return pos;
    }

    Queue<RoboInst> search(MapParser map){
        Queue<RoboInst> robots = new LinkedList<RoboInst>();
        for(int i = 0; i < dr.length; i++){
            int row = pos.row + dr[i];
            int col = pos.col + dc[i];
            int tileValue = map.getTileValue(row,col);
            if(tileValue == 0)
                continue;
            robots.add(new RoboInst(power - tileValue, row, col));
        }
        return robots;
    }
}
