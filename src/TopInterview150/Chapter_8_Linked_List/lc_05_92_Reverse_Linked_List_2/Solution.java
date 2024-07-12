package TopInterview150.Chapter_8_Linked_List.lc_05_92_Reverse_Linked_List_2;

import LeetCode75.Chapter_8_Linked_List.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode current = head;
        ListNode oldHead = new ListNode();
        ListNode tempOldHead = oldHead;
        ListNode lastPrev = null;
        for (int i = 1; current != null;i++) {
            if (i < left) {
                tempOldHead.next = new ListNode(current.val);
                tempOldHead = tempOldHead.next;
                current = current.next;
            } else if (i <= right) {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                if (lastPrev == null){
                    lastPrev = prev;
                }
                current = next;
            } else {
                break;
            }
        }
        if (lastPrev!=null){
            lastPrev.next = current;
        }
        tempOldHead.next = prev;
        return oldHead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode x = solution.reverseBetween(node, 2, 4);
        System.out.println(x);
    }
}
