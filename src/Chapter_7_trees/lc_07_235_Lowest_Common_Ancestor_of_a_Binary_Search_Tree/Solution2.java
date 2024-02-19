package Chapter_7_trees.lc_07_235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import Chapter_7_trees.TreeNode;

public class Solution2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (q.val > root.val && p.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (q.val < root.val && p.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.left = new TreeNode(3);

        root.right = new TreeNode(8);
        root.right.right = new TreeNode(9);
        root.right.left = new TreeNode(7);

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);

        Solution2 solution = new Solution2();
        System.out.println(solution.lowestCommonAncestor(root, p, q).val);
    }
}
