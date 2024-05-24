package Interview_prepare.newrub;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        boolean leftToRight = true;

        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                if (leftToRight) {
                    TreeNode currentNode = deque.pollFirst();
                    currentLevel.add(currentNode.val);

                    if (currentNode.left != null) deque.offerLast(currentNode.left);
                    if (currentNode.right != null) deque.offerLast(currentNode.right);
                } else {
                    TreeNode currentNode = deque.pollLast();
                    currentLevel.add(currentNode.val);

                    if (currentNode.right != null) deque.offerFirst(currentNode.right);
                    if (currentNode.left != null) deque.offerFirst(currentNode.left);
                }
            }

            result.add(currentLevel);
            leftToRight = !leftToRight;
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        BinaryTreeLevelOrderTraversal tree = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> levels = tree.levelOrder(root);
        for (List<Integer> level : levels) {
            System.out.println(level);
        }
    }
}
