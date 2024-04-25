package Chapter_7_trees.lc_02_104_Maximum_Depth_of_Binary_Tree;

import Chapter_7_trees.TreeNode;

public class Solution2 {
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    public int maxDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        return Math.max(maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1));
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        System.out.println(solution.maxDepth(root));
    }
}
