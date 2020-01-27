package UIL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
    private Map<String, Map<String, Integer>> nodes = new HashMap<String, Map<String, Integer>>();
    Set<String> visited = new HashSet<String>();

    public void addVertex(String s) {
        nodes.put(s, new HashMap<String, Integer>());
    }

    public void addEdge(String source, String destination, int val) {
        if (!nodes.containsKey(source))
            addVertex(source);

        if (!nodes.containsKey(destination))
            addVertex(destination);

        nodes.get(source).put(destination, val);
        nodes.get(destination).put(source, val);
    }

    public Map<String, Integer> getAdjacencies(String source) {
        return nodes.get(source);
    }
}
