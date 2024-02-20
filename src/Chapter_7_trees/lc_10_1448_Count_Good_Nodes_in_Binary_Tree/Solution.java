package Chapter_7_trees.lc_10_1448_Count_Good_Nodes_in_Binary_Tree;

import Chapter_7_trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int goodNodes(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        goodNodes(root,  Integer.MIN_VALUE, list);
        return list.size();
    }

    private void goodNodes(TreeNode root, int max, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (max <= root.val) {
            list.add(root.val);
        }
        goodNodes(root.left, Math.max(max, root.val), list);
        goodNodes(root.right, Math.max(max, root.val), list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(1);
        Solution solution = new Solution();
        System.out.println(solution.goodNodes(root));
    }
}
