package Chapter_7_trees.lc_01_226_Invert_Binary_Tree;

import Chapter_7_trees.TreeNode;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        invertTreeHelper(root);
        return root;
    }

    public void invertTreeHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        invertTreeHelper(root.left);
        invertTreeHelper(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.right.left = new TreeNode(6);
        solution.invertTree(root);
    }
}
