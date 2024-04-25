package Chapter_7_trees.lc_01_226_Invert_Binary_Tree;

import Chapter_7_trees.TreeNode;

public class Solution2 {
    public TreeNode invertTree(TreeNode root) {
        invertTreeHelper(root);
        return root;
    }
    public void invertTreeHelper(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTreeHelper(root.left);
        invertTreeHelper(root.right);
    }
}
