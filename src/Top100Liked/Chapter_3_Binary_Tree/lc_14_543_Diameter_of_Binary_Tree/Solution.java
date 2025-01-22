package Top100Liked.Chapter_3_Binary_Tree.lc_14_543_Diameter_of_Binary_Tree;

import Chapter_7_trees.TreeNode;

public class Solution {
    int max = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int left = 1 + dfs(root.left);
        int right = 1 + dfs(root.right);
        max = Math.max(max, left + right);
        return 1 + Math.max(left, right);
    }
}
