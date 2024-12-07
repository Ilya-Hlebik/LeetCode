package Top100Liked.Chapter_9_Linked_List.lc_14_234_Palindrome_Linked_List;

import LeetCode75.Chapter_8_Linked_List.ListNode;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current!=null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        while (head!=prev){
            if (head.val != prev.val){
                return false;
            }
            head = head.next;
            prev = prev.next;
        }
        return true;
    }
}
