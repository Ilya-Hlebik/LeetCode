package TopInterview150.Chapter_8_Linked_List.lc_06_25_Reverse_Nodes_in_k_Group;

import LeetCode75.Chapter_8_Linked_List.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode();
        ListNode prev = null;
        ListNode current = head;
        ListNode sizeNode = head;
        int listSize = 0;
        while (sizeNode != null) {
            listSize++;
            sizeNode = sizeNode.next;
        }
        ListNode temp = result;
        for (int i = k - 1; current != null; i--) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            listSize--;
            if (i == 0) {
                i = k;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = prev;
                prev = null;
                if (listSize < i) {
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = current;
                    break;
                }
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(4);
        listNode1.next.next.next.next = new ListNode(5);
        solution.reverseKGroup(listNode1, 2);
    }
}
