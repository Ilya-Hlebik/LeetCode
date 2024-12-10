package Top100Liked.Chapter_9_Linked_List.lc_14_234_Palindrome_Linked_List;

import LeetCode75.Chapter_8_Linked_List.ListNode;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode headCopy = new ListNode(head.val);
        ListNode temp = headCopy;
        while (current!=null){
            ListNode next = current.next;
            if (next!=null){
                temp.next = new ListNode(next.val);
                temp = temp.next;
            }
            current.next = prev;
            prev = current;
            current = next;
        }
        while (headCopy!=prev){
            if (headCopy.val != prev.val){
                return false;
            }
            headCopy = headCopy.next;
            prev = prev.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        solution.isPalindrome(head);
    }
}
