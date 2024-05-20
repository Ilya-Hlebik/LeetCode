package LeetCode75.Chapter_8_Linked_List.lc_03_2130_Maximum_Twin_Sum_of_a_Linked_List;

import LeetCode75.Chapter_8_Linked_List.ListNode;

public class Solution2 {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!= null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode current = slow;
        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        int max = Integer.MIN_VALUE;
        while (prev !=null ) {
            max = Math.max(prev.val + head.val, max);
            prev = prev.next;
            head = head.next;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        ListNode listNode = new ListNode(5);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(2);

        listNode.next.next.next = new ListNode(1);
        System.out.println(solution.pairSum(listNode));
    }
}
