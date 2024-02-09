package Chapter_6_linked_list.lc_03_143_Reorder_List;

import Chapter_6_linked_list.ListNode;

public class Solution2 {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode current = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        ListNode tempHead = head;
        ListNode first = head.next;
        ListNode second = prev;
        for (int i = 1; second != null || first != null; i++) {
            if (i % 2 == 0) {
                tempHead.next = first;
                first = first.next;
            } else {
                tempHead.next = second;
                second = second.next;
            }
            tempHead = tempHead.next;
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        solution.reorderList(listNode);
    }
}
