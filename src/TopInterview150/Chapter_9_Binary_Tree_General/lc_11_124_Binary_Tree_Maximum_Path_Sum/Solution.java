package TopInterview150.Chapter_9_Binary_Tree_General.lc_11_124_Binary_Tree_Maximum_Path_Sum;

import Chapter_7_trees.TreeNode;

public class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        max = root.val;
        maxPathSumHelper(root);
        return max;
    }

    public int maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, maxPathSumHelper(root.left));
        int right = Math.max(0, maxPathSumHelper(root.right));
        max = Math.max(root.val + left + right, max);

        return root.val + Math.max(left, right);
    }
}
