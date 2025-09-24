package freeRun.lc_46_203_Remove_Linked_List_Elements;

import LeetCode75.Chapter_8_Linked_List.ListNode;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode();
        ListNode temp = result;
        while (head != null) {
            ListNode next = head.next;
            if (head.val != val) {
                temp.next = head;
                temp = temp.next;
                temp.next = null;
            }
            head = next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
         ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
/*        ListNode head = new ListNode(7);
        head.next = new ListNode(7);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(7);*/
        solution.removeElements(head, 6);
    }
}
