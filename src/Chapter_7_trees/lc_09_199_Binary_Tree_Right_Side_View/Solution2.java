package Chapter_7_trees.lc_09_199_Binary_Tree_Right_Side_View;

import Chapter_7_trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideView(root, result, 1);
        return result;
    }

    private void rightSideView(TreeNode root, List<Integer> result, int level) {
        if (root == null) {
            return;
        }
        if (level > result.size()) {
            result.add(root.val);
        }
        rightSideView(root.right, result, level + 1);
        rightSideView(root.left, result, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        System.out.println(new Solution2().rightSideView(root));
    }
}
