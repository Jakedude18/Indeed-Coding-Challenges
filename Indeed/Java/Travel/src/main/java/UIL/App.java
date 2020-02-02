package UIL;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner dat = new Scanner(new File("travel.dat"));
        Graph planets = new Graph();
        Breath sort = new Breath();
        int sets = dat.nextInt();
        for (int j = 0; j < sets; j++) {
            StringBuilder res = new StringBuilder();
            int count = dat.nextInt();
            for (int k = 0; k < count; k++) {
                planets.addEdge(dat.next(), dat.next(), dat.nextInt());
            }
            List<Node> paths = new ArrayList<Node>();

            //breath first search
            Queue<Node> breath = new LinkedList<Node>();
            String start = dat.next();
            breath.add(new Node(start, 0));
            String end = dat.next();
            while (!breath.isEmpty()) {
                Node cur = breath.poll();
                for (Map.Entry<String, Integer> node : planets.getAdjacencies(cur.name).entrySet()) {
                    if (node.getKey().equals(end)) {
                        paths.add(cur.addChild(node.getKey(), node.getValue()));
                        break;
                    }
                    if (!planets.visited.contains(node.getKey())) {
                        breath.add(cur.addChild(node.getKey(), node.getValue()));
                        planets.visited.add(node.getKey());
                    }
                }
            }

            //determine fastest path
            Node fastestPath = paths.get(0);
            for (Node node : paths) {
                if (sort.listTime(node) < sort.listTime(fastestPath))
                    fastestPath = node;
            }
            sort.listTime(fastestPath);
            //don't append newline to string builder
            if (j != 0)
                System.out.println();
            res.append(fastestPath.name);
            while (fastestPath.parent != null) {
                res.insert(0, fastestPath.parent.name + " to ");
                fastestPath = fastestPath.parent;
            }
            System.out.print(res);
        }
    }
}
