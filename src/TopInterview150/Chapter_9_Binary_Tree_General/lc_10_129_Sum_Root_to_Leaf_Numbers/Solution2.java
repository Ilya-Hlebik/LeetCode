package TopInterview150.Chapter_9_Binary_Tree_General.lc_10_129_Sum_Root_to_Leaf_Numbers;

import Chapter_7_trees.TreeNode;

public class Solution2 {

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int currentSum) {
        if (root == null) {
            return 0;
        }
        currentSum = currentSum *10 +root.val;
        if (root.left == null && root.right == null) {
            return currentSum;
        }
        return sumNumbers(root.left, currentSum) + sumNumbers(root.right, currentSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(0);
        Solution2 solution = new Solution2();
        System.out.println(solution.sumNumbers(root));
    }
}
