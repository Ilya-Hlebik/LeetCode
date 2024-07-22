package TopInterview150.Chapter_9_Binary_Tree_General.lc_03_226_Invert_Binary_Tree;

import Chapter_7_trees.TreeNode;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }
}
