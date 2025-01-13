package Top100Liked.Chapter_3_Binary_Tree.lc_08_114_Flatten_Binary_Tree_to_Linked_List;


import Chapter_7_trees.TreeNode;

public class Solution {
    TreeNode node = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = node;
        node = root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        solution.flatten(root);
    }
}
