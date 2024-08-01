package TopInterview150.Chapter_9_Binary_Tree_General.lc_10_129_Sum_Root_to_Leaf_Numbers;

import Chapter_7_trees.TreeNode;

public class Solution {
    int result = 0;

    public int sumNumbers(TreeNode root) {
        sumNumbers(root, "");
        return result;
    }

    public void sumNumbers(TreeNode root, String s) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result += Integer.parseInt(s + root.val);
        }
        sumNumbers(root.left, s + root.val);
        sumNumbers(root.right, s + root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(0);
        Solution solution = new Solution();
        System.out.println(solution.sumNumbers(root));
    }
}
