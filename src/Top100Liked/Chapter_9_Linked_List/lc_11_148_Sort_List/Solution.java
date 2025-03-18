package Top100Liked.Chapter_9_Linked_List.lc_11_148_Sort_List;

import LeetCode75.Chapter_8_Linked_List.ListNode;

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(slow);
        return merge(h1, h2);
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }
        if (h1.val < h2.val) {
            h1.next = merge(h1.next, h2);
            return h1;
        } else {
            h2.next = merge(h2.next, h1);
            return h2;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode root = new ListNode(4);
        root.next = new ListNode(2);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(3);
        solution.sortList(root);
    }
}
