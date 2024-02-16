package Chapter_7_trees.lc_04_110_Balanced_Binary_Tree;

import Chapter_7_trees.TreeNode;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        return left && right && Math.abs(isBalanced(root.left, 0) - isBalanced(root.right, 0)) < 2;
    }

    public int isBalanced(TreeNode root, int height) {
        if (root == null) {
            return height;
        }
        int left = isBalanced(root.left, height + 1);
        int right = isBalanced(root.right, height + 1);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
/*        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(15);*/
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.left.left = new TreeNode(4);
        treeNode.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(3);
        treeNode.right.right.right = new TreeNode(4);
        System.out.println(solution.isBalanced(treeNode));
    }
}
