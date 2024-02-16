package Chapter_7_trees.lc_06_572_Subtree_of_Another_Tree;

import Chapter_7_trees.TreeNode;

public class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        boolean left = isSubtree(root.left, subRoot);
        boolean right = isSubtree(root.right, subRoot);

        return left || right || compareTrees(root, subRoot);
    }

    public boolean compareTrees(TreeNode leaf, TreeNode subRoot) {
        if (leaf == null && subRoot == null){
            return true;
        }
        if (leaf == null || subRoot == null || leaf.val != subRoot.val){
            return false;
        }

        return compareTrees(leaf.left, subRoot.left) && compareTrees(leaf.right, subRoot.right);
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(3);
        p.left = new TreeNode(4);
        p.left.left  = new TreeNode(1);
        p.left.right  = new TreeNode(2);
        p.right = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        q.left = new TreeNode(1);
        q.right = new TreeNode(2);
        Solution solution = new Solution();
        System.out.println(solution.isSubtree(p, q));
    }
}
