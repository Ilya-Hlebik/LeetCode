package LeetCode75.Chapter_9_Binary_Tree_DFS.lc_06_236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import Chapter_7_trees.TreeNode;

public class Solution {
    int maxLevel = Integer.MIN_VALUE;
    TreeNode commonAncestor = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestorHelper(root, p, q, 0);
        return commonAncestor;
    }

    private void lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q, int level) {
        if (root == null) {
            return;
        }
        boolean dfs = dfs(root, p, q, level, new ContainsPAndQ());
        if (dfs) {
            commonAncestor = root;
        }
        lowestCommonAncestorHelper(root.left, p, q, level + 1);
        lowestCommonAncestorHelper(root.right, p, q, level + 1);
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q, int level, ContainsPAndQ containsPAndQ) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            containsPAndQ.containsP = true;
        }
        if (root == q) {
            containsPAndQ.containsQ = true;
        }
        if (containsPAndQ.containsP && containsPAndQ.containsQ) {
            if (level > maxLevel) {
                maxLevel = level;
                return true;
            }
        }
        return dfs(root.left, p, q, level, containsPAndQ) ||
                dfs(root.right, p, q, level, containsPAndQ);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.right = new TreeNode(8);
        root.right.left = new TreeNode(0);
        System.out.println(solution.lowestCommonAncestor(root, root.left, root.right).val);
    }
}

class ContainsPAndQ {
    boolean containsP = false;
    boolean containsQ = false;
}
