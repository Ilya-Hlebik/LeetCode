package Chapter_7_trees.lc_13_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import Chapter_7_trees.TreeNode;

import java.util.Arrays;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int mid = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                mid = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid + 1),
                Arrays.copyOfRange(inorder, 0, mid));
        root.right = buildTree(Arrays.copyOfRange(preorder, mid + 1, preorder.length),
                Arrays.copyOfRange(inorder, mid + 1, inorder.length));
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        solution.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
    }
}
