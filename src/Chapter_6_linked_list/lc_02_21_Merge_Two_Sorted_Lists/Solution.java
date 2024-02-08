package Chapter_6_linked_list.lc_02_21_Merge_Two_Sorted_Lists;

import Chapter_6_linked_list.ListNode;

public class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = null;
        ListNode temp = null;
        while (list1 != null || list2 != null) {
            if (list2 == null || (list1 != null && list1.val < list2.val)) {
                if (result == null) {
                    result = new ListNode(list1.val);
                    temp = result;
                } else {
                    ListNode nextNode = new ListNode(list1.val);
                    temp.next = nextNode;
                    temp = temp.next;
                }
                list1 = list1.next;
            } else {
                if (result == null) {
                    result = new ListNode(list2.val);
                    temp = result;
                } else {
                    ListNode nextNode = new ListNode(list2.val);
                    temp.next = nextNode;
                    temp = temp.next;
                }
                list2 = list2.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);
        ListNode listNode = solution.mergeTwoLists(listNode1, listNode2);
        System.out.println();
    }
}
