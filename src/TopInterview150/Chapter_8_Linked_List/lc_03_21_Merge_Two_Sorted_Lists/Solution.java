package TopInterview150.Chapter_8_Linked_List.lc_03_21_Merge_Two_Sorted_Lists;

import LeetCode75.Chapter_8_Linked_List.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode temp = result;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    temp.next = new ListNode(list1.val);
                    list1 = list1.next;
                } else {
                    temp.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
            } else if (list1 != null) {
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            else {
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            temp = temp.next;
        }
        return result.next;
    }
}
