package Chapter_7_trees.lc_03_543_Diameter_of_Binary_Tree;

import Chapter_7_trees.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class Solution2 {
    public int diameterOfBinaryTree(TreeNode root) {
        AtomicInteger current = new AtomicInteger(0);
        dfs(root, current);
        return current.get();
    }

    private int dfs(TreeNode root, AtomicInteger current) {
        if (root == null) {
            return -1;
        }
        int left = 1 + dfs(root.left, current);
        int right = 1 + dfs(root.right, current);
        current.set(Math.max(current.get(), left + right));
        return Math.max(left, right);
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        System.out.println(solution.diameterOfBinaryTree(root));
    }
}
