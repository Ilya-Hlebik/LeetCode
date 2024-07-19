package TopInterview150.Chapter_8_Linked_List.lc_10_86_Partition_List;

import LeetCode75.Chapter_8_Linked_List.ListNode;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

    public ListNode partition(ListNode head, int x) {
        Map<Integer, ListNode> map = new LinkedHashMap<>();
        ListNode temp = head;
        for (int i = 0; temp!=null; i++){
            map.put(i, new ListNode(temp.val));
            temp = temp.next;
        }
        ListNode result = new ListNode();
        ListNode prefix = result;
        ListNode suffix = new ListNode();
        ListNode suffixTemp = suffix;
        for (Map.Entry<Integer, ListNode> integerListNodeEntry : map.entrySet()) {
            if (integerListNodeEntry.getValue().val < x){
                prefix.next = integerListNodeEntry.getValue();
                prefix = prefix.next;
            }
            else {
                suffix.next = integerListNodeEntry.getValue();
                suffix = suffix.next;
            }
        }
        prefix.next = suffixTemp.next;
        return result.next;
    }
}
