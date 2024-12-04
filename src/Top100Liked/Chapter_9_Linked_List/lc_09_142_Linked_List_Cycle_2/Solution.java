package Top100Liked.Chapter_9_Linked_List.lc_09_142_Linked_List_Cycle_2;

import LeetCode75.Chapter_8_Linked_List.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> element = new HashSet<>();
        ListNode temp = head;
        while (temp!=null&& temp.next!=null){
            if (element.contains(temp.next)){
                return temp.next;
            }
            element.add(temp);
            temp = temp.next;
        }
        return null;
    }
}
