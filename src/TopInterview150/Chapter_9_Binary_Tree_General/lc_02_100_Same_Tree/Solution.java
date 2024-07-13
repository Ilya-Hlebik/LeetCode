package TopInterview150.Chapter_9_Binary_Tree_General.lc_02_100_Same_Tree;

import Chapter_7_trees.TreeNode;

public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return (p == null && q == null) || (p != null && q != null) && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
