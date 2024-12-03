package Top100Liked.Chapter_9_Linked_List.lc_05_24_Swap_Nodes_in_Pairs;

import LeetCode75.Chapter_8_Linked_List.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode result = new ListNode();
        ListNode tempResult = result;
        int count = 0;
        while (current != null) {
            count++;
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            if (count == 2 || next == null) {
                while (tempResult.next != null) {
                    tempResult = tempResult.next;
                }
                tempResult.next = prev;
                prev = null;
                count = 0;
            }
            current = next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        solution.swapPairs(head);
    }
}
