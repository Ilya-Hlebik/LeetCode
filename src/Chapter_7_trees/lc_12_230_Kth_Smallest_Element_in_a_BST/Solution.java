package Chapter_7_trees.lc_12_230_Kth_Smallest_Element_in_a_BST;

import Chapter_7_trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        return kthSmallest(root, k, new ArrayList<>());
    }

    public int kthSmallest(TreeNode root, int k, List<Integer> list) {
        if (root == null) {
            return -1;
        }
        int left = kthSmallest(root.left, k, list);
        list.add(root.val);
        if (k == list.size()) {
            return list.get(k - 1);
        }
        int right = kthSmallest(root.right, k, list);
        return left == -1 ? right : left;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        Solution solution = new Solution();
        System.out.println(solution.kthSmallest(root, 1));
    }
}
