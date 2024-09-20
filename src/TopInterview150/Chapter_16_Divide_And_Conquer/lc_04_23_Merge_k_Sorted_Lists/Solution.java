package TopInterview150.Chapter_16_Divide_And_Conquer.lc_04_23_Merge_k_Sorted_Lists;

import LeetCode75.Chapter_8_Linked_List.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode();
        ListNode temp = result;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list != null) {
                priorityQueue.add(list);
            }
        }
        while (!priorityQueue.isEmpty()) {
            ListNode poll = priorityQueue.poll();
            temp.next = poll;
            poll = poll.next;
            temp = temp.next;
            if (poll != null) {
                priorityQueue.add(poll);
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        solution.mergeKLists(new ListNode[]{node1, node2, node3});
    }
}
