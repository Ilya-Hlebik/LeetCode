package Chapter_6_linked_list.lc_03_143_Reorder_List;

import Chapter_6_linked_list.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void reorderList(ListNode head) {
        List<ListNode> nodeList = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            nodeList.add(temp);
            temp = temp.next;
        }
        ListNode temp2 = head;
        for (int i = 1, j = 1, k = nodeList.size() - 1; i < nodeList.size(); i++) {
            if (i % 2 == 0) {
                temp2.next = nodeList.get(j);
                j++;
            }
            else {
                temp2.next = nodeList.get(k);
                k--;
            }

                temp2 = temp2.next;
        }
        temp2.next = null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        solution.reorderList(listNode);
        System.out.println();
    }
}
