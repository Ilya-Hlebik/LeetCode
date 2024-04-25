package Chapter_7_trees.lc_04_110_Balanced_Binary_Tree;

import Chapter_7_trees.TreeNode;

public class Solution2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(dfs(root.left, 0) - dfs(root.right, 0)) <=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int dfs(TreeNode root, int height) {
       if (root == null){
           return height;
       }
       return Math.max(dfs(root.left, height+1), dfs(root.right, height+1));
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
/*        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(15);*/
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.left.left = new TreeNode(4);
        treeNode.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(3);
        treeNode.right.right.right = new TreeNode(4);
        System.out.println(solution.isBalanced(treeNode));
    }
}
