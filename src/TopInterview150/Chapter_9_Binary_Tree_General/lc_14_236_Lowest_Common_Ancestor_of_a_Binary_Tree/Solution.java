package TopInterview150.Chapter_9_Binary_Tree_General.lc_14_236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import Chapter_7_trees.TreeNode;

public class Solution {
    int savedLevel = -1;
    TreeNode response = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        response = root;
        lowestCommonAncestorHelper(root, p, q, 0);
        return response;
    }

    public void lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q, int level) {
        if (root == null) {
            return;
        }
        lowestCommonAncestorHelper(root.left, p, q, level + 1);
        if (dfs(root, p, q, new ContainPAndQ())) {
            if (level > savedLevel) {
                response = root;
                savedLevel = level;
            }
        }
        lowestCommonAncestorHelper(root.right, p, q, level + 1);
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q, ContainPAndQ containPAndQ) {
        if (root == null) {
            return false;
        }

        if (root .equals(p)) {
            containPAndQ.containsP = true;
        }
        if (root .equals( q)) {
            containPAndQ.containsQ = true;
        }
        if (     containPAndQ.containsP  &&    containPAndQ.containsQ ) {
            return true;
        }

        return dfs(root.left, p, q, containPAndQ) || dfs(root.right, p, q, containPAndQ);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(-2);
        root.left.left.left = new TreeNode(8);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        Solution solution = new Solution();
        solution.lowestCommonAncestor(root,    root.left.left.left,    root.left.right );
    }
}
class ContainPAndQ{
    boolean containsP = false;
    boolean containsQ = false;
}
