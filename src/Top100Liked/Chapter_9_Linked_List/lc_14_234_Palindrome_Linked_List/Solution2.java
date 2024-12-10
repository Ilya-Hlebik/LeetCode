package Top100Liked.Chapter_9_Linked_List.lc_14_234_Palindrome_Linked_List;

import LeetCode75.Chapter_8_Linked_List.ListNode;

public class Solution2 {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head, prev;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        prev = slow;
        slow = slow.next;
        prev.next = null;

        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        while (prev != null) {
            if (head.val != prev.val) {
                return false;
            }
            head = head.next;
            prev = prev.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        solution.isPalindrome(head);
    }
}
