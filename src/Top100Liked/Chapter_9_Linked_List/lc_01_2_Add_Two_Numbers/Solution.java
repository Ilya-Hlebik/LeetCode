package Top100Liked.Chapter_9_Linked_List.lc_01_2_Add_Two_Numbers;

import Chapter_6_linked_list.ListNode;

import java.util.Optional;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode tempList = result;
        int temp = 0;
        while (l1 != null || l2 != null || temp != 0) {
            int sum = Optional.ofNullable(l1).map(listNode -> listNode.val).orElse(0)
                    + Optional.ofNullable(l2).map(listNode -> listNode.val).orElse(0)
                    + temp;
            ListNode next = new ListNode(sum % 10);
            temp = sum / 10;
            tempList.next = next;
            tempList = tempList.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return result.next;
    }
}
