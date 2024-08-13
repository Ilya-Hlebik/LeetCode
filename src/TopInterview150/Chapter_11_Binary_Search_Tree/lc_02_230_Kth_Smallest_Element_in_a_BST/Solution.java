package TopInterview150.Chapter_11_Binary_Search_Tree.lc_02_230_Kth_Smallest_Element_in_a_BST;

import Chapter_7_trees.TreeNode;

public class Solution {
    int target;

    public int kthSmallest(TreeNode root, int k) {
        target = k;
        return dfs(root, k);
    }

    public int dfs(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        int left = dfs(root.left, k);
        if (--target == 0) {
            return root.val;
        }
        int right = dfs(root.right, k);
        return left != -1 ? left : right;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        Solution solution = new Solution();
        System.out.println(solution.kthSmallest(root, 3));
    }
}
