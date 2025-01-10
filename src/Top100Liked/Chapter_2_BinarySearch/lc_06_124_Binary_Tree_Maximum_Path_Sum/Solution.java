package Top100Liked.Chapter_2_BinarySearch.lc_06_124_Binary_Tree_Maximum_Path_Sum;

import Chapter_7_trees.TreeNode;

public class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        return Math.max(dfs(root), max);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, dfs(root.left));
        int val = root.val;
        int right = Math.max(0, dfs(root.right));
        max = Math.max(max, val + right + left);
        return val + Math.max(left, right);
    }
}
