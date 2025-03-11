import java.util.*;

public class CloneGraph {
    public static class Node {
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

    Map<Integer, Node> newNodes = new HashMap<>();
    Deque<Node> next = new ArrayDeque<>();

    public Node cloneGraph(Node node) {
        if(node == null) return null;

        next.addLast(node);
        Node newGraph = new Node(node.val);
        newNodes.put(node.val, newGraph);

        while (!next.isEmpty()) {
            Node curr = next.pollFirst();
            List<Node> neighbors = getNewNeighbors(curr);
            Node newCurr = newNodes.get(curr.val);
            newCurr.neighbors = neighbors;
            System.out.println(newCurr.val);
        }

        return newGraph;
    }

    private List<Node> getNewNeighbors(Node curr) {
        List<Node> neighbors = new ArrayList<>();

        for(Node neigh : curr.neighbors) {
            Node node = newNodes.get(neigh.val);
            if(node == null) {
                next.addLast(neigh);
                Node nNode = new Node(neigh.val);
                newNodes.put(neigh.val, nNode);
                neighbors.add(nNode);
            } else {
                neighbors.add(node);
            }
        }

        return neighbors;
    }
}
