package LeetCode75.Chapter_9_Binary_Tree_DFS.lc_03_1448_Count_Good_Nodes_in_Binary_Tree;

import Chapter_7_trees.TreeNode;

public class Solution {
    public int goodNodes(TreeNode root) {
        return goodNodesHelper(root, root.val);
    }

    public int goodNodesHelper(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.val >= max) {
            count++;
        }
        count += goodNodesHelper(root.left, Math.max(max, root.val))
                + goodNodesHelper(root.right, Math.max(max, root.val));
        return count;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(2);
        Solution solution = new Solution();
        System.out.println(solution.goodNodes(treeNode));
    }
}
