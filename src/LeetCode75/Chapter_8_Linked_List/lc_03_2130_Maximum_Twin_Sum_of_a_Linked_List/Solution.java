package LeetCode75.Chapter_8_Linked_List.lc_03_2130_Maximum_Twin_Sum_of_a_Linked_List;

import LeetCode75.Chapter_8_Linked_List.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int pairSum(ListNode head) {
        if (head == null){
            return 0;
        }
        ListNode current = head;
        List<Integer> values = new ArrayList<>();
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }
        int max = 0;
        for (int i = 0; i < values.size() / 2; i++) {
            max = Math.max(values.get(i) + values.get(values.size() - i - 1), max);
        }
        return max;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(5);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(2);

        listNode.next.next.next = new ListNode(1);
        System.out.println(solution.pairSum(listNode));
    }
}
