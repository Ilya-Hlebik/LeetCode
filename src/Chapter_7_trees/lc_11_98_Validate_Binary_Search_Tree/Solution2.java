package Chapter_7_trees.lc_11_98_Validate_Binary_Search_Tree;

import Chapter_7_trees.TreeNode;

public class Solution2 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2147483647);
       /* root.left = new TreeNode(1);
        root.right = new TreeNode(3);*/
        Solution2 solution = new Solution2();
        System.out.println(solution.isValidBST(root));
    }
}
