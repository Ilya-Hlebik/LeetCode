package LeetCode75.Chapter_10_Binary_Tree_BFS.lc_01_199_Binary_Tree_Right_Side_View;

import Chapter_7_trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> nodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                    nodes.add(poll.left.val);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                    nodes.add(poll.right.val);
                }
            }
            if (!nodes.isEmpty()){
                result.add(nodes.get(nodes.size()-1));
            }
        }
        return result;
    }
}
