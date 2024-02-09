package Chapter_6_linked_list.lc_05_138_Copy_List_with_Random_Pointer;

import Chapter_6_linked_list.Node;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Node copyRandomList(Node head) {
        Node result = null;
        Node temp = null;
        Map<Node, Node> map = new HashMap<>();
        while (head != null) {
            map.putIfAbsent(head, new Node(head.val));
            if (head.random != null) {
                map.putIfAbsent(head.random, new Node(head.random.val));
            }
            if (head.next != null){
                map.putIfAbsent(head.next, new Node(head.next.val));
            }
            if (result == null) {
                result = map.get(head);
                temp = result;
                result.next = head.next == null? null: map.get(head.next);
            } else {
                result.next = head.next == null? null: map.get(head.next);
            }
            if (head.random != null) {
                result.random = map.get(head.random);
            }
            head = head.next;
            result = result.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node2.random = node1;
        node3.next = node4;
        node3.random = node5;
        node4.next = node5;
        node4.random = node3;
        node5.random = node1;
        solution.copyRandomList(node1);
    }
}
