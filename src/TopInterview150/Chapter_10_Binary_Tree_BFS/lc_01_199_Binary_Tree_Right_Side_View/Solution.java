package TopInterview150.Chapter_10_Binary_Tree_BFS.lc_01_199_Binary_Tree_Right_Side_View;

import Chapter_7_trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        result.add(root.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> line = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    line.add(poll.left.val);
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    line.add(poll.right.val);
                    queue.add(poll.right);
                }
            }
            if (!line.isEmpty()) {
                result.add(line.get(line.size() - 1));
            }
        }
        return result;
    }
}
