package freeRun.lc_28_147_Insertion_Sort_List;

import LeetCode75.Chapter_8_Linked_List.ListNode;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode temp = head;
        ListNode next = null;
        ListNode l = new ListNode(0);
        while (temp != null) {
            next = temp.next;
            ListNode p = l;
            while (p.next != null && p.next.val < temp.val) {
                p = p.next;
            }
            temp.next = p.next;
            p.next = temp;
            temp = next;
        }
        return l.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        solution.insertionSortList(head);
    }
}
