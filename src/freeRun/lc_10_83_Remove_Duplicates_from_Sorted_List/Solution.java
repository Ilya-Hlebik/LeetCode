package freeRun.lc_10_83_Remove_Duplicates_from_Sorted_List;

import Chapter_6_linked_list.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp!=null){
            ListNode next = temp.next;
            while (next!=null && next.val == temp.val){
                temp.next = next.next;
                next = temp.next;
            }
            temp = temp.next;
        }
        return head;
    }
}
