package Top100Liked.Chapter_3_Binary_Tree.lc_03_101_Symmetric_Tree;

import Chapter_7_trees.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        return left == null && right == null
                || (left != null && right != null && left.val == right.val && dfs(left.left, right.right)
                && dfs(left.right, right.left));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);

        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);

        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(3);

        System.out.println(solution.isSymmetric(treeNode));
    }
}
