package TopInterview150.Chapter_8_Linked_List.lc_07_19_Remove_Nth_Node_From_End_of_List;

import LeetCode75.Chapter_8_Linked_List.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        while (n != 0) {
            fast = fast.next;
            n--;
        }
        if (fast == null) return head.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
/*        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5); */
        ListNode x = solution.removeNthFromEnd(node, 2);
        System.out.println(x);
    }
}
