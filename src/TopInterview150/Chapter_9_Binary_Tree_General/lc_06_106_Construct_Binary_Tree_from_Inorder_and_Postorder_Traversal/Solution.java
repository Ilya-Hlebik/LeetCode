package TopInterview150.Chapter_9_Binary_Tree_General.lc_06_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import Chapter_7_trees.TreeNode;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i : postorder) {
            stack.push(i);
        }

        return buildTree(inorder, stack);
    }

    public TreeNode buildTree(int[] inorder, Stack<Integer> postorder) {
        if (inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder.pop());
        int mid = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                mid = i;
                break;
            }
        }
        root.right = buildTree(Arrays.copyOfRange(inorder, mid + 1, inorder.length), postorder);
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, mid), postorder);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }
}
