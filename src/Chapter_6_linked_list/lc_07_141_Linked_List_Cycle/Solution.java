package Chapter_6_linked_list.lc_07_141_Linked_List_Cycle;

import Chapter_6_linked_list.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head !=null){
            if (set.contains(head)){
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(3);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(0);
        listNode1.next.next.next = new ListNode(-4);
        listNode1.next.next.next.next =    listNode1.next;
        System.out.println(solution.hasCycle(listNode1));
    }
}

