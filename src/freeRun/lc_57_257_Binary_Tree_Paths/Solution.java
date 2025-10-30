package freeRun.lc_57_257_Binary_Tree_Paths;

import Chapter_7_trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        compute(root, new StringBuilder());
        return result;
    }

    public void compute(TreeNode root, StringBuilder nodes) {
        if (root == null) {
            return;
        }
        if (nodes.length() == 0) {
            nodes = new StringBuilder(nodes).append(root.val);
        } else {
            nodes = new StringBuilder(nodes).append("->").append(root.val);
        }
        if (root.left == null && root.right == null) {
            result.add(nodes.toString());
        }
        compute(root.left, nodes);
        compute(root.right, nodes);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        solution.binaryTreePaths(root);
    }
}
