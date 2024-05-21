package LeetCode75.Chapter_11_Binary_Search_Tree.lc_02_450_Delete_Node_in_a_BST;

import Chapter_7_trees.TreeNode;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        deleteNodeHelper(root, key);
        return root;
    }

    private void deleteNodeHelper(TreeNode root, int key, TreeNode previous) {
        if (root == null){
            return;
        }
    }
}
