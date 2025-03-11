package Top100Liked.Chapter_9_Linked_List.lc_03_21_Merge_Two_Sorted_Lists;

import LeetCode75.Chapter_8_Linked_List.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode temp = result;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null && list1.val < list2.val || list2 == null) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
            temp.next = null;
        }
        return result.next;
    }
}
