package LeetCode75.Chapter_9_Binary_Tree_DFS.lc_05_1372_Longest_ZigZag_Path_in_a_Binary_Tree;

import Chapter_7_trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Map.Entry<TreeNode, Boolean>, Integer> memo = new HashMap<>();

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int longest = Math.max(dfs(root, true, -1), dfs(root, false, -1));
        longest = Math.max(longest, longestZigZag(root.left));
        longest = Math.max(longest, longestZigZag(root.right));
        return longest;
    }

    private int dfs(TreeNode root, boolean goLeft, int current) {
        if (root == null) {
            return current;
        }
        Map.Entry<TreeNode, Boolean> key = Map.entry(root, goLeft);
        if (memo.containsKey(key)){
            return memo.get(key);
        }
        int max = 0;
        if (goLeft) {
            max = dfs(root.left, false, current + 1);
        } else {
            max = dfs(root.right, true, current + 1);
        }
        memo.put(key, max);
        return max;
    }
}
