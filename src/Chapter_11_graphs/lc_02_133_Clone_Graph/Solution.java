package Chapter_11_graphs.lc_02_133_Clone_Graph;

import Chapter_11_graphs.Node;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node3);
        node4.neighbors.add(node1);
        solution.cloneGraph(node1);
    }

    public Node cloneGraph(Node node) {
        if (node == null){
            return null;
        }
        if (node.val == 0){
            return new Node();
        }
        Map<Integer, Node> uniqueNodes = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Set<Integer> processed = new HashSet<>();

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (processed.contains(poll.val)){
                continue;
            }
            processed.add(poll.val);
            Node newNode = uniqueNodes.getOrDefault(poll.val, new Node(poll.val));
            uniqueNodes.put(newNode.val, newNode);
            newNode.neighbors.addAll(poll.neighbors.stream().map(node1 -> {
                if (uniqueNodes.containsKey(node1.val)) {
                    return uniqueNodes.get(node1.val);
                }
                Node defaultValue = new Node(node1.val);
                uniqueNodes.put(node1.val, defaultValue);
                return defaultValue;
            }).collect(Collectors.toList()));

            for (Node neighbor : poll.neighbors) {
                if (!processed.contains(neighbor.val)) {
                    queue.add(neighbor);
                }
            }
        }
        return uniqueNodes.get(node.val);
    }


}
