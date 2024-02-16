package Chapter_7_trees.lc_05_100_Same_Tree;

import Chapter_7_trees.TreeNode;

public class Solution2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        boolean leftSame = isSameTree(p.left, q.left);
        boolean rightSame = isSameTree(p.right, q.right);
        return leftSame && rightSame;
    }
}
