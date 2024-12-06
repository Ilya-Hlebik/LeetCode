package Top100Liked.Chapter_9_Linked_List.lc_12_160_Intersection_of_Two_Linked_Lists;

import LeetCode75.Chapter_8_Linked_List.ListNode;

public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a    ;
    }
}
