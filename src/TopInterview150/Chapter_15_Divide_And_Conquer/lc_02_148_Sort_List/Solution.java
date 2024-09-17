package TopInterview150.Chapter_15_Divide_And_Conquer.lc_02_148_Sort_List;

import LeetCode75.Chapter_8_Linked_List.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public ListNode sortList(ListNode head) {
        List<ListNode> forSort = new ArrayList<>();
        ListNode temp = head;
        while (temp!=null){
            forSort.add(temp);
            temp = temp.next;
        }
        forSort.sort((Comparator.comparingInt(o -> o.val)));
        ListNode result = new ListNode();
        temp = result;
        for (ListNode listNode : forSort) {
            temp.next = listNode;
            temp = temp.next;
        }
        temp.next = null;
        return result.next;
    }
}
