package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    public static void main(String[] args) {

    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> Q = new LinkedList<>();
        Q.offer(node);
        map.put(node, new Node(node.val));
        while (!Q.isEmpty()) {
            Node existing = Q.poll();
            Node copyGraph = map.get(existing);
            for (Node neighbor : existing.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    Q.add(neighbor);
                }
                copyGraph.neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}
