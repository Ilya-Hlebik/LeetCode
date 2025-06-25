package freeRun.lc_19_109_Convert_Sorted_List_to_Binary_Search_Tree;

import Chapter_6_linked_list.ListNode;
import Chapter_7_trees.TreeNode;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return dfs(head, null);
    }

    private TreeNode dfs(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = dfs(head, slow);
        root.right = dfs(slow.next, tail);
        return root;
    }
}
