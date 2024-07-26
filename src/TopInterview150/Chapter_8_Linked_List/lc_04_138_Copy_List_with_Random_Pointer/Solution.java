package TopInterview150.Chapter_8_Linked_List.lc_04_138_Copy_List_with_Random_Pointer;

import Chapter_6_linked_list.Node;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToNewMap = new HashMap<>();
        Node result = new Node(0);
        Node temp = result;
        Node tempHead = head;
        while (tempHead != null) {
            temp.next = new Node(tempHead.val);
            oldToNewMap.put(tempHead, temp.next);
            tempHead = tempHead.next;
            temp = temp.next;
        }
        temp = result.next;
        while (head != null) {
            if (head.random != null) {
                temp.random = oldToNewMap.get(head.random);
            }
            head = head.next;
            temp = temp.next;
        }
        return result.next;
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
