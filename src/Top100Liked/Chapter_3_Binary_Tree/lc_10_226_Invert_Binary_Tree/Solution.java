package Top100Liked.Chapter_3_Binary_Tree.lc_10_226_Invert_Binary_Tree;

import Chapter_7_trees.TreeNode;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(temp);
        return root;
    }
}
