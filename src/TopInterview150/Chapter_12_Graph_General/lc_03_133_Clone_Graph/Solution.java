package TopInterview150.Chapter_12_Graph_General.lc_03_133_Clone_Graph;

import Chapter_11_graphs.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public HashMap<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node newNode = new Node(node.val);
        map.put(newNode.val, newNode);
        newNode.neighbors = new ArrayList<>();
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        return newNode;
    }
}
