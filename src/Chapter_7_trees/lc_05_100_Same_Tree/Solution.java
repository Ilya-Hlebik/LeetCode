package Chapter_7_trees.lc_05_100_Same_Tree;

import Chapter_7_trees.TreeNode;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        StringBuilder sP = new StringBuilder();
        treeToString(p, sP);
        StringBuilder sQ = new StringBuilder();
        treeToString(q, sQ);
        return sP.toString().equals(sQ.toString());
    }

    private void treeToString(TreeNode p, StringBuilder stringBuilder) {
        if (p == null) {
            stringBuilder.append("null,");
            return;
        }
        treeToString(p.left, stringBuilder);
        treeToString(p.right, stringBuilder);
        stringBuilder.append(p.val).append(",");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        solution.isSameTree(p, q);
    }
}
