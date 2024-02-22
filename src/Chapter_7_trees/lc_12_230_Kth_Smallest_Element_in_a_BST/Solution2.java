package Chapter_7_trees.lc_12_230_Kth_Smallest_Element_in_a_BST;

import Chapter_7_trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        kthSmallest(root, list);
        return list.get(k - 1);
    }

    public void kthSmallest(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        kthSmallest(root.left, list);
        list.add(root.val);
        kthSmallest(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        Solution2 solution = new Solution2();
        System.out.println(solution.kthSmallest(root, 1));
    }
}
