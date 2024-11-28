package Top100Liked.Chapter_3_Binary_Tree.lc_01_94_Binary_Tree_Inorder_Traversal;

import Chapter_7_trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        }
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
        return result;
    }
}
