package Chapter_6_linked_list.lc_11_25_Reverse_Nodes_in_k_Group;

import Chapter_6_linked_list.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode current = head;
        List<ListNode> listNodes = new ArrayList<>();
        while (current != null) {
            listNodes.add(current);
            current = current.next;
        }
        current = head;
        ListNode prev = null;
        ListNode result = new ListNode();
        ListNode temp = result;
        int j = 0;
        for (int i = 0; i < listNodes.size() + 1; i++) {
            if (i != 0 && i % k == 0) {
                temp.next = prev;
                while (temp.next != null) {
                    temp = temp.next;
                }
                prev = null;
                j = i;
            }
            if (i == listNodes.size()) {
                break;
            }
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        for (; j < listNodes.size(); j++) {
            current = listNodes.get(j);
            temp.next = current;
            temp = temp.next;
        }
        temp.next = null;
        return result.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(4);
        listNode1.next.next.next.next = new ListNode(5);
        solution.reverseKGroup(listNode1, 3);
    }
}
