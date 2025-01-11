package Top100Liked.Chapter_3_Binary_Tree.lc_05_104_Maximum_Depth_of_Binary_Tree;

import Chapter_7_trees.TreeNode;

public class Solution {
    int max = Integer.MIN_VALUE;

    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return max;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
        max = Math.max(max, depth);
    }
}
