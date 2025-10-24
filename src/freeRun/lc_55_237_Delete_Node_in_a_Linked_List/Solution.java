package freeRun.lc_55_237_Delete_Node_in_a_Linked_List;

import Chapter_6_linked_list.ListNode;

public class Solution {
    public void deleteNode(ListNode node) {
        ListNode temp = node;
        while (temp.next != null) {
            temp.val = temp.next.val;
            if (temp.next.next == null) {
                temp.next = null;
            } else {
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = new ListNode(4);
        node.next = new ListNode(5);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(9);
        solution.deleteNode(node.next);
    }
}
