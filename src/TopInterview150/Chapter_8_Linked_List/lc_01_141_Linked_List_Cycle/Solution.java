package TopInterview150.Chapter_8_Linked_List.lc_01_141_Linked_List_Cycle;

import LeetCode75.Chapter_8_Linked_List.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (set.contains(head)){
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
