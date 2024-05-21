package LeetCode75.Chapter_10_Binary_Tree_BFS.lc_02_1161_Maximum_Level_Sum_of_a_Binary_Tree;

import Chapter_7_trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1;
        int maxLevel = 1;
        int max = root.val;
        queue.add(root);
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            int sum = 0;
            boolean emptyLevel = true;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    emptyLevel = false;
                    queue.add(poll.left);
                    sum += poll.left.val;
                }
                if (poll.right != null) {
                    emptyLevel = false;
                    queue.add(poll.right);
                    sum += poll.right.val;
                }
            }
            if (!emptyLevel && sum > max) {
                max = sum;
                maxLevel = level;
            }

        }
        return maxLevel;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(-100);
        treeNode.left = new TreeNode(-200);
        treeNode.left.left = new TreeNode(-20);
        treeNode.left.right = new TreeNode(-5);
        treeNode.right = new TreeNode(-300);
        treeNode.right.left = new TreeNode(-10);

        System.out.println(solution.maxLevelSum(treeNode));
    }
}
