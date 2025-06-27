package freeRun.lc_20_111_Minimum_Depth_of_Binary_Tree;

import Chapter_7_trees.TreeNode;

public class Solution {
    int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
       return dfs(root, 1);
    }

    private int dfs(TreeNode root, int depth) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int left = dfs(root.left, depth + 1);
        if (root.left == null && root.right == null) {
            return depth;
        }
        int right = dfs(root.right, depth + 1);
        return Math.min(left, right);
    }
}
