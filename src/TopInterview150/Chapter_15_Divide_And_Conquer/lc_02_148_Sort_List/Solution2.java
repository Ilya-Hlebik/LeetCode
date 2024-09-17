package TopInterview150.Chapter_15_Divide_And_Conquer.lc_02_148_Sort_List;

import LeetCode75.Chapter_8_Linked_List.ListNode;

public class Solution2 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode pre = null;
        while (p2 != null && p2.next != null) {
            pre = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        pre.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(p1);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode temp = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            }
            else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1!=null){
            temp.next = l1;
        }
        if (l2!=null){
            temp.next = l2;
        }
        temp.next = null;
        return result.next;
    }
}
