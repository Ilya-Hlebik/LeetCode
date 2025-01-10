package Top100Liked.Chapter_3_Binary_Tree.lc_02_98_Validate_Binary_Search_Tree;

import Chapter_7_trees.TreeNode;

public class Solution {
    Integer current = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBST(root.left) && checkCurrent(root.val) && isValidBST(root.right);
    }

    private boolean checkCurrent(int val) {
        if (current == null) {
            current = val;
            return true;
        }
        if (current >= val) {
            return false;
        }
        current = val;
        return true;
    }
}
