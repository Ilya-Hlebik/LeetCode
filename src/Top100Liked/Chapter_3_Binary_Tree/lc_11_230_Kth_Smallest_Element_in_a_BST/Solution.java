package Top100Liked.Chapter_3_Binary_Tree.lc_11_230_Kth_Smallest_Element_in_a_BST;

import Chapter_7_trees.TreeNode;

import java.util.PriorityQueue;

public class Solution {
    PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return queue.poll();
    }

    public void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        int val = root.val;
        queue.add(val);
        if (queue.size() > k ) {
            queue.poll();
        }
        dfs(root.left, k);
        dfs(root.right, k);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(2);
/*        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);*/
        System.out.println(solution.kthSmallest(root, 3));
    }
}
