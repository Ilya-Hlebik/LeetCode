package TopInterview150.Chapter_8_Linked_List.lc_02_2_Add_Two_Numbers;

import LeetCode75.Chapter_8_Linked_List.ListNode;

import java.util.Optional;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int remain = 0;
        ListNode listNode = new ListNode();
        ListNode temp = listNode;
        while (l1 != null || l2 != null || remain!=0) {
            int sum = Optional.ofNullable(l1).map(node -> node.val).orElse(0) + Optional.ofNullable(l2).map(node -> node.val).orElse(0) + remain;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            remain = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return listNode.next;
    }
}
