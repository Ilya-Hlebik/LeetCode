package LeetCode75.Chapter_8_Linked_List.lc_01_2095_Delete_the_Middle_Node_of_a_Linked_List;


import LeetCode75.Chapter_8_Linked_List.ListNode;

public class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head ==null || head.next == null){
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head;
        while (fast != null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);

        Solution solution = new Solution();
        solution.deleteMiddle(listNode);
    }
}
