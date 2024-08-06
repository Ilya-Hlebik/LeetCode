package TopInterview150.Chapter_9_Binary_Tree_General.lc_12_173_Binary_Search_Tree_Iterator;

import Chapter_7_trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(20);
        root.right.left = new TreeNode(9);
        Solution solution = new Solution();
        BSTIterator bstIterator = new BSTIterator(root);
        System.out.println(bstIterator.next());
    }
}

class BSTIterator {

    public BSTIterator(TreeNode root) {
        dfs(root);
    }

    Queue<Integer> queue = new LinkedList<>();

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        queue.add(root.val);
        dfs(root.right);
    }

    public int next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
