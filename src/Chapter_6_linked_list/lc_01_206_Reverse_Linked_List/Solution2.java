package Chapter_6_linked_list.lc_01_206_Reverse_Linked_List;

import Chapter_6_linked_list.ListNode;

public class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode resultHead = head;
        if (head.next != null){
            resultHead = reverseList(head.next);
            head.next.next = head;
        }
        head.next = null;
        return resultHead;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        ListNode x = solution.reverseList(node);
        System.out.println(x);
    }
}
