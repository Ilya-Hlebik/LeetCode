package Chapter_6_linked_list.lc_04_19_Remove_Nth_Node_From_End_of_List;

import Chapter_6_linked_list.ListNode;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        if (slow.next == null){
            return slow;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
/*        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5) ;*/
        ListNode listNode1 = solution.removeNthFromEnd(listNode, 2);
        System.out.println();
    }
}
