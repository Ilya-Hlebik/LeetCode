package Chapter_7_trees.lc_03_543_Diameter_of_Binary_Tree;

import Chapter_7_trees.TreeNode;

public class Solution {
    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;
    }

    public int dfs(TreeNode root) {
        if (root == null){
            return -1;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        result = Math.max(left + right + 2, result);
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        System.out.println(solution.diameterOfBinaryTree(root));
    }
}
