package Top100Liked.Chapter_3_Binary_Tree.lc_12_236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import Chapter_7_trees.TreeNode;

import java.util.concurrent.atomic.AtomicBoolean;

public class Solution {
    TreeNode lowest = null;
    int lowestLevel = Integer.MIN_VALUE;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        dfs(root, p, q, 0);
        return lowest;
    }

    private void dfs(TreeNode root, TreeNode p, TreeNode q, int level) {
        if (root == null) {
            return;
        }
        if (level > lowestLevel && containsNodes(root, p, q, new AtomicBoolean(), new AtomicBoolean())) {
            lowest = root;
            lowestLevel = level;
        }
        dfs(root.left, p, q, level + 1);
        dfs(root.right, p, q, level + 1);
    }

    private boolean containsNodes(TreeNode root, TreeNode p, TreeNode q, AtomicBoolean containsP, AtomicBoolean containsQ) {
        if (root == null) {
            return false;
        }
        if (root.equals(p)) {
            containsP.set(true);
        }
        if (root.equals(q)) {
            containsQ.set(true);
        }
        if (containsP.get() && containsQ.get()) {
            return true;
        }

        return containsNodes(root.left, p, q, containsP, containsQ) || containsNodes(root.right, p, q, containsP, containsQ);
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
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        System.out.println(solution.lowestCommonAncestor(root, root.left, root.right).val);
    }
}
