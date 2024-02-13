package Chapter_6_linked_list.lc_10_23_Merge_k_Sorted_Lists;

import Chapter_6_linked_list.ListNode;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode();
        ListNode temp = result;
        while (true) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && min > lists[i].val) {
                    min = lists[i].val;
                    minIndex = i;
                }
            }
            if (minIndex == -1) {
                break;
            } else {
                temp.next = lists[minIndex];
                temp = temp.next;
                lists[minIndex] = lists[minIndex].next;
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);

        solution.mergeKLists(new ListNode[]{listNode1, listNode2, listNode3});
    }
}
