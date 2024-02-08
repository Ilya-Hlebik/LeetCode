package Chapter_6_linked_list.lc_01_206_Reverse_Linked_List;

import Chapter_6_linked_list.ListNode;
//1 -> 2 -> 3
//1
//1

//     2 -> 1

// 3 -> 2 -> 1

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current!=null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        ListNode x = solution.reverseList(node);
        System.out.println(x);
    }
}
