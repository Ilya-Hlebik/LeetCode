package TopInterview150.Chapter_10_Binary_Tree_BFS.lc_04_103_Binary_Tree_Zigzag_Level_Order_Traversal;

import Chapter_7_trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftFirst = true;
        while (!queue.isEmpty()) {
            leftFirst = !leftFirst;
            int size = queue.size();
            List<Integer> current = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (leftFirst) {
                    current.add(0, poll.val);
                } else {
                    current.add(poll.val);
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            result.add(current);
        }
        return result;
    }
}
