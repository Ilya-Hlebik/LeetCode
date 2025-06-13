package freeRun.lc_14_95_Unique_Binary_Search_Trees_2;

import Chapter_7_trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> generateTrees(int n) {
        for (int i = 1; i<= n; i++){
            dfs(null, null, n, i);
        }
        return result;
    }

    public void dfs(TreeNode root, TreeNode tempNode, int n, int temp) {
        if (root == null) {
            root = new TreeNode(temp);
            tempNode = root;
            dfs(root, tempNode, n, temp + 1);
        } else if (temp > n) {
            result.add(root);
        } else {
            if (temp > tempNode.val) {
                tempNode.right = new TreeNode(temp);
                dfs(root, tempNode.right, n, temp + 1);
            } else {
                tempNode.left = new TreeNode(temp);
                dfs(root, tempNode.left, n, temp + 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generateTrees(3);
    }
}
