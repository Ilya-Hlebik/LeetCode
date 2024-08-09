package TopInterview150.Chapter_10_Binary_Tree_BFS.lc_02_2_637_Average_of_Levels_in_Binary_Tree;

import Chapter_7_trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        result.add((double) root.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double currentValue = 0.0;
            int count = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                    currentValue+=poll.left.val;
                    count++;
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                    currentValue+=poll.right.val;
                    count++;
                }
            }
            if (count!=0){
                result.add(currentValue/count);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);

        solution.averageOfLevels(root);
    }
}
