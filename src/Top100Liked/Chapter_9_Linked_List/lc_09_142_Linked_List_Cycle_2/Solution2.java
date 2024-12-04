package Top100Liked.Chapter_9_Linked_List.lc_09_142_Linked_List_Cycle_2;

import LeetCode75.Chapter_8_Linked_List.ListNode;

public class Solution2 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
