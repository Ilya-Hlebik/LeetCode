package Top100Liked.Chapter_9_Linked_List.lc_12_160_Intersection_of_Two_Linked_Lists;

import LeetCode75.Chapter_8_Linked_List.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA!=null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
