package Chapter_6_linked_list.lc_07_141_Linked_List_Cycle;

import Chapter_6_linked_list.ListNode;

public class Solution2 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        ListNode listNode1 = new ListNode(3);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(0);
        listNode1.next.next.next = new ListNode(-4);
        listNode1.next.next.next.next =    listNode1.next;
        System.out.println(solution.hasCycle(listNode1));
    }
}

