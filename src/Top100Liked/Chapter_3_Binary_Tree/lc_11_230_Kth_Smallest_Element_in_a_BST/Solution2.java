package Top100Liked.Chapter_3_Binary_Tree.lc_11_230_Kth_Smallest_Element_in_a_BST;

import Chapter_7_trees.TreeNode;

public class Solution2 {
    int target;

    public int kthSmallest(TreeNode root, int k) {
        target = k;
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int left = dfs(root.left);
        if (--target == 0) {
            return root.val;
        }
        int right = dfs(root.right);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        /*  root.right.right = new TreeNode(6);*/
        System.out.println(solution.kthSmallest(root, 3));
    }
}
