package Top100Liked.Chapter_3_Binary_Tree.lc_13_437_Path_Sum_3;

import Chapter_7_trees.TreeNode;

public class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int count = dfs(root, targetSum);
        count += pathSum(root.left, targetSum);
        count += pathSum(root.right, targetSum);
        return count;
    }

    private int dfs(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        targetSum -= root.val;
        int count = 0;
        if (targetSum == 0) {
            count++;
        }
        count += dfs(root.left, targetSum);
        count += dfs(root.right, targetSum);
        return count;
    }

/*    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        Solution solution = new Solution();
        System.out.println(solution.pathSum(root, 8));
    }*/

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);
        Solution solution = new Solution();
        System.out.println(solution.pathSum(root, -2));
    }
}
