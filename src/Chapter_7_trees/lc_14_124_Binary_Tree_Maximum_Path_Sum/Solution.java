package Chapter_7_trees.lc_14_124_Binary_Tree_Maximum_Path_Sum;

import Chapter_7_trees.TreeNode;

public class Solution {
    public int maxPathSum(TreeNode root) {
        CurrentSum currentSum = new CurrentSum(root.val);
        dfs(root, currentSum);
        return currentSum.sum;
    }

    public int dfs(TreeNode root, CurrentSum currentSum) {
        if (root == null) {
            return 0;
        }
        int leftMax = dfs(root.left, currentSum);
        int rightMax = dfs(root.right, currentSum);
        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);
        currentSum.sum = Math.max(currentSum.sum, leftMax + rightMax + root.val);
        return root.val + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(4);

        System.out.println(solution.maxPathSum(root));
    }
}

class CurrentSum {
    int sum;

    public CurrentSum(int sum) {
        this.sum = sum;
    }
}
