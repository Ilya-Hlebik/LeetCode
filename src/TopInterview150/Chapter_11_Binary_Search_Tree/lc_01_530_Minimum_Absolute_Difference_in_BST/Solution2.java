package TopInterview150.Chapter_11_Binary_Search_Tree.lc_01_530_Minimum_Absolute_Difference_in_BST;

import Chapter_7_trees.TreeNode;

public class Solution2 {
    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return min;
        }
        getMinimumDifference(root.left);
        if (prev != null) {
            min = Math.min(root.val - prev, min);
        }
        prev = root.val;
        getMinimumDifference(root.right);
        return min;
    }
}
