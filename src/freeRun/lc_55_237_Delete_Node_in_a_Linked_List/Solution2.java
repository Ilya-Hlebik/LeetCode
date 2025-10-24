package freeRun.lc_55_237_Delete_Node_in_a_Linked_List;

import Chapter_6_linked_list.ListNode;

public class Solution2 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        ListNode node = new ListNode(4);
        node.next = new ListNode(5);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(9);
        solution.deleteNode(node.next);
    }
}
