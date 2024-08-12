package TopInterview150.Chapter_11_Binary_Search_Tree.lc_01_530_Minimum_Absolute_Difference_in_BST;

import Chapter_7_trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        for (int i = 0; i < list.size(); i++) {
            TreeNode current = list.get(i);
            for (TreeNode toCompare : list) {
                if (current == toCompare) {
                    continue;
                }
                min = Math.min(Math.abs(current.val - toCompare.val), min);
            }
        }
        return min;
    }

    public void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
