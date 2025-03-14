package Top100Liked.Chapter_9_Linked_List.lc_08_141_Linked_List_Cycle;

import LeetCode75.Chapter_8_Linked_List.ListNode;

public class Solution {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}
