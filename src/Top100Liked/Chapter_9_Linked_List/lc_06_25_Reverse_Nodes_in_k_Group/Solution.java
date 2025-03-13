package Top100Liked.Chapter_9_Linked_List.lc_06_25_Reverse_Nodes_in_k_Group;

import LeetCode75.Chapter_8_Linked_List.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode();
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        temp = result;
        for (; size >= k; size -= k) {
            ListNode prev = null;
            for (int i = 0; i < k; i++) {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            temp.next = prev;
            while (temp.next != null) {
                temp = temp.next;
            }
        }
        temp.next = head;
        return result.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        solution.reverseKGroup(root, 2);
    }
}
