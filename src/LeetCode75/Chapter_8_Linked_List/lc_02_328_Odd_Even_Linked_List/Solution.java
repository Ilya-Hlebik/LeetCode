package LeetCode75.Chapter_8_Linked_List.lc_02_328_Odd_Even_Linked_List;

import LeetCode75.Chapter_8_Linked_List.ListNode;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode even = head;
        ListNode odd = head.next;
        ListNode oddHead = odd;
        while (odd != null && odd.next != null) {
            even.next = even.next.next;
            odd.next = odd.next.next;
            even = even.next;
            odd = odd.next;
        }
        even.next = oddHead;
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);

        listNode.next.next.next = new ListNode(4);

        listNode.next.next.next.next = new ListNode(5);
/*        listNode.next.next.next.next.next = new ListNode(6);
        listNode.next.next.next.next.next.next = new ListNode(7);
        listNode.next.next.next.next.next.next.next = new ListNode(8);*/

        solution.oddEvenList(listNode);
    }
}
