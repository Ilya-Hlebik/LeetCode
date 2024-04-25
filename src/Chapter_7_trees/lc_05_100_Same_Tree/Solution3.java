package Chapter_7_trees.lc_05_100_Same_Tree;

import Chapter_7_trees.TreeNode;

public class Solution3 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        StringBuilder stringBuilder = new StringBuilder();
        isSameHelper(p, stringBuilder);
        StringBuilder stringBuilder2 = new StringBuilder();
        isSameHelper(q, stringBuilder2);
        return stringBuilder.toString().equals(stringBuilder2.toString());
    }
    public void isSameHelper(TreeNode treeNode, StringBuilder stringBuilder){
        if (treeNode ==null){
            stringBuilder.append("null");
            return;
        }
        isSameHelper(treeNode.left, stringBuilder);
        isSameHelper(treeNode.right, stringBuilder);
        stringBuilder.append(treeNode.val);
    }
}
