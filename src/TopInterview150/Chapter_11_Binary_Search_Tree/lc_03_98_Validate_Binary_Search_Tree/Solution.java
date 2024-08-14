package TopInterview150.Chapter_11_Binary_Search_Tree.lc_03_98_Validate_Binary_Search_Tree;

import Chapter_7_trees.TreeNode;

public class Solution {
    Integer prev = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (prev != null) {
            if (prev >= root.val) {
                return false;
            }
        }
        prev = root.val;
        boolean right = isValidBST(root.right);
        return left && right;
    }
}
