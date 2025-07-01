package freeRun.lc_22_112_Path_Sum_2;

import Chapter_7_trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> temp) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            result.add(new ArrayList<>(temp));
        } else {
            dfs(root.left, targetSum - root.val, temp);
            dfs(root.right, targetSum - root.val, temp);
        }
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.left.left = new TreeNode(11);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);

        treeNode.right = new TreeNode(8);

        solution.pathSum(treeNode, 22);
    }
}
