package LeetCode75.Chapter_9_Binary_Tree_DFS.lc_01_104_Maximum_Depth_of_Binary_Tree;

import Chapter_7_trees.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        return maxHelper(root, 0);
    }

    public int maxHelper(TreeNode root, int max) {
        if (root == null) {
            return max;
        }

        int left = maxHelper(root.left, max + 1);
        int right = maxHelper(root.right, max + 1);

        return Math.max(left, right);
    }
}
