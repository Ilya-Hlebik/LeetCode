package freeRun.lc_16_99_Recover_Binary_Search_Tree;

import Chapter_7_trees.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    List<Integer> values = new ArrayList<>();
    int index = 0;

    public void recoverTree(TreeNode root) {
        dfs(root);
        Collections.sort(values);
        swap(root);
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        values.add(root.val);
        dfs(root.right);
    }

    public void swap(TreeNode root) {
        if (root == null) {
            return;
        }
        swap(root.left);
        root.val = values.get(index++);
        swap(root.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        solution.recoverTree(root);
    }
}
