package TopInterview150.Chapter_8_Linked_List.lc_09_61_Rotate_List;

import LeetCode75.Chapter_8_Linked_List.ListNode;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = new ListNode();
        temp.next = head;
        ListNode fast = temp;
        ListNode slow = temp;
        int i = 0;

        for (; fast.next != null; i++) {
            fast = fast.next;
        }
        for (int j = i - k % i; j > 0; j--) {
            slow = slow.next;
        }
        fast.next = head;
        temp.next = slow.next;
        slow.next = null;
        return temp.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        solution.rotateRight(node, 2);
    }
}
