package Top100Liked.Chapter_9_Linked_List.lc_04_23_Merge_k_Sorted_Lists;

import LeetCode75.Chapter_8_Linked_List.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((Comparator.comparingInt(o -> o.val)));
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        ListNode result = new ListNode();
        ListNode temp = result;
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            temp.next = poll;
            temp = temp.next;
            poll = poll.next;
            if (poll != null) {
                queue.add(poll);
            }
        }
        return result.next;
    }
}
