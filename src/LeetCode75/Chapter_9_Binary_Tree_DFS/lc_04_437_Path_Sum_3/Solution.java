package LeetCode75.Chapter_9_Binary_Tree_DFS.lc_04_437_Path_Sum_3;

import Chapter_7_trees.TreeNode;

public class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int counter = 0;
        counter += pathSumHelper(root, targetSum, 0);
        counter += pathSum(root.left, targetSum);
        counter += pathSum(root.right, targetSum);
        return counter;
    }

    private int pathSumHelper(TreeNode root, int targetSum, long currentSum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (currentSum + root.val == targetSum) {
            count++;
        }
        count += pathSumHelper(root.left, targetSum, currentSum + root.val);
        count += pathSumHelper(root.right, targetSum, currentSum + root.val);
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
     /*   TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(-3);
        treeNode.left.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(11);
        treeNode.left.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(2);
        treeNode.left.right.right = new TreeNode(1);
        treeNode.left.left.right = new TreeNode(-2);*/
        TreeNode treeNode = new TreeNode(1000000000);
        treeNode.left = new TreeNode(1000000000);
        treeNode.left.left = new TreeNode(294967296);
        treeNode.left.left.left = new TreeNode(1000000000);
        treeNode.left.left.left.left = new TreeNode(1000000000);
        treeNode.left.left.left.left.left = new TreeNode(1000000000);

        System.out.println(solution.pathSum(treeNode, 0));
    }
}
