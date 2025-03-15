package Top100Liked.Chapter_9_Linked_List.lc_07_138_Copy_List_with_Random_Pointer;

import Chapter_6_linked_list.Node;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Node copyRandomList(Node head) {
        Node result = new Node(0);
        Node temp = result;
        Map<Node, Node> map = new HashMap<>();
        while (head != null) {
            map.put(head, map.getOrDefault(head, new Node(head.val)));
            temp.next = map.get(head);
            if ( head.random  != null) {
                map.put(head.random, map.getOrDefault(head.random, new Node(head.random.val)));
                temp.next.random = map.get(head.random);
            }
            temp = temp.next;
            head = head.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node7 = new Node(7);
        Node node1 = new Node(1);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node13 = new Node(13);

        node7.next = node13;
        node7.next.next = node11;
        node11.next = node10;
        node10.next = node1;

        node13.random = node7;
        node11.random = node1;
        node10.random = node11;
        node1.random = node7;


        solution.copyRandomList(node7);
    }
}
