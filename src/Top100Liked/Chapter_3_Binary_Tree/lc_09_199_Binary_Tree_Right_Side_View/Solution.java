package Top100Liked.Chapter_3_Binary_Tree.lc_09_199_Binary_Tree_Right_Side_View;

import Chapter_7_trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer temp = null;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                temp = poll.val;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
