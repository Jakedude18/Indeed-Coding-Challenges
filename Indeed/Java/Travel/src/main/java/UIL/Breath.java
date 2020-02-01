package UIL;

public class Breath {
    int listTime(Node path) {
        int tot = 0;
        while (path != null) {
            tot += path.val;
            path = path.parent;
        }
        return tot;
    }
}
