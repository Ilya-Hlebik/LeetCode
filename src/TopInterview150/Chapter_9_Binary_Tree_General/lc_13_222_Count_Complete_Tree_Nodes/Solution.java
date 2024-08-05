package TopInterview150.Chapter_9_Binary_Tree_General.lc_13_222_Count_Complete_Tree_Nodes;

import Chapter_7_trees.TreeNode;

public class Solution {
    int count = 0;

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        count++;
        countNodes(root.left);
        countNodes(root.right);
        return count;
    }
}
