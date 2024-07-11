package TopInterview150.Chapter_8_Linked_List.lc_05_92_Reverse_Linked_List_2;

import LeetCode75.Chapter_8_Linked_List.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode current = head;
        int i =1;
        ListNode oldHead = new ListNode();
        while (current != null) {
            if (i<left){
                oldHead.next = new ListNode(current.val);
                current = current.next;
            }
            else if(i<=right) {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            else {
                break;
            }
            i++;
        }
        oldHead.next = prev;
        return oldHead.next;
    }
}
