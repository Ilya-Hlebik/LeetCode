package freeRun.lc_23_116_Populating_Next_Right_Pointers_in_Each_Node;


import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (prev != null) {
                    prev.next = poll;
                }
                prev = poll;
                if (poll.left != null) {
                    queue.add(poll.left);
                    queue.add(poll.right);
                }
            }
        }
        return root;
    }
}
