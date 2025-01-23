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
        int left =  dfs(root.left);
        int right =  dfs(root.right);
        max = Math.max(left + right + 2, max);
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        solution.diameterOfBinaryTree(root);
    }
}
