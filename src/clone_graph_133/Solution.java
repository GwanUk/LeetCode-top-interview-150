package clone_graph_133;

import java.util.ArrayList;
import java.util.List;

class Solution {

    Node[] graph = new Node[101];

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        } else if (node.neighbors == null) {
            return new Node(1);
        }
        return clone(node);
    }

    private Node clone(Node target) {
        int v = target.val;

        if (graph[v] == null) {
            graph[v] = new Node(v);

            for (Node neighbor : target.neighbors) {
                Node clone = clone(neighbor);
                graph[v].neighbors.add(clone);
            }
        }

        return graph[v];
    }

    // Definition for a Node.
    static class Node {
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
}