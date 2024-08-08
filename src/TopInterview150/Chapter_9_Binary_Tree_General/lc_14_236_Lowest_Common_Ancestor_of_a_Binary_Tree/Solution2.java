package TopInterview150.Chapter_9_Binary_Tree_General.lc_14_236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import Chapter_7_trees.TreeNode;

public class Solution2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left == null) {
            return right;
        } else {
            return left;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(-2);
        root.left.left.left = new TreeNode(8);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        Solution2 solution = new Solution2();
        solution.lowestCommonAncestor(root, root.left.left.left, root.left.right);
    }
}
