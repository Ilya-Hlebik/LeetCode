package Chapter_6_linked_list.lc_06_2_Add_Two_Numbers;

import Chapter_6_linked_list.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode result = head;
        int temp = 0;
        while (l1 != null || l2 != null) {
            int sum = temp;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            head.next = new ListNode(sum % 10);
            temp = sum / 10;
            head = head.next;
        }
        if (temp != 0) {
            head.next = new ListNode(temp);
        }
        return result.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(9);
        listNode1.next = new ListNode(9);
        listNode1.next.next = new ListNode(9);
        listNode1.next.next.next = new ListNode(9);
        listNode1.next.next.next.next = new ListNode(9);
        listNode1.next.next.next.next.next = new ListNode(9);
        listNode1.next.next.next.next.next.next = new ListNode(9);


        ListNode listNode2 = new ListNode(9);
        listNode2.next = new ListNode(9);
        listNode2.next.next = new ListNode(9);
        listNode2.next.next.next = new ListNode(9);
        solution.addTwoNumbers(listNode1, listNode2);
    }
}
