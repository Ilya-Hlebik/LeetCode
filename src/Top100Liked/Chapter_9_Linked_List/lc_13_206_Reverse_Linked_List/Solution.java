package Top100Liked.Chapter_9_Linked_List.lc_13_206_Reverse_Linked_List;

import LeetCode75.Chapter_8_Linked_List.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
