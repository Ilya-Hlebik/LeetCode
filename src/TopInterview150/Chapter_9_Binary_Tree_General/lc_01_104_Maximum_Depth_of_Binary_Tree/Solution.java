package TopInterview150.Chapter_9_Binary_Tree_General.lc_01_104_Maximum_Depth_of_Binary_Tree;

import Chapter_7_trees.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        return maxDep(root, 0);
    }
    private int maxDep(TreeNode root, int level){
        if (root == null){
            return level;
        }
        return Math.max(maxDep(root.left, level+1), maxDep(root.right, level+1));
    }
}
