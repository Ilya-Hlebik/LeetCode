package TopInterview150.Chapter_8_Linked_List.lc_08_82_Remove_Duplicates_from_Sorted_List_2;

import LeetCode75.Chapter_8_Linked_List.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        Set<Integer> excludedValues = new HashSet<>();
        Set<Integer> currentValues = new HashSet<>();

        while (temp != null) {
            if (currentValues.contains(temp.val)) {
                excludedValues.add(temp.val);
            }
            currentValues.add(temp.val);
            temp = temp.next;
        }
        temp = head;
        ListNode res = new ListNode();
        ListNode resTemp = res;
        while (temp != null) {
            if (!excludedValues.contains(temp.val)) {
                resTemp.next = temp;
                resTemp = resTemp.next;
            }
            temp = temp.next;
        }
        resTemp.next = null;
        return res.next;
    }
}
