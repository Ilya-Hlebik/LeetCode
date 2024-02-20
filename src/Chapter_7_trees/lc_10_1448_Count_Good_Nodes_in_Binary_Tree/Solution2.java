package Chapter_7_trees.lc_10_1448_Count_Good_Nodes_in_Binary_Tree;

import Chapter_7_trees.TreeNode;

public class Solution2 {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    private int goodNodes(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (max <= root.val) {
            res++;
        }
        res += goodNodes(root.left, Math.max(max, root.val));
        res += goodNodes(root.right, Math.max(max, root.val));
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(1);
        Solution2 solution = new Solution2();
        System.out.println(solution.goodNodes(root));
    }
}
