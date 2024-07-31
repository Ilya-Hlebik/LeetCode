package TopInterview150.Chapter_9_Binary_Tree_General.lc_08_114_Flatten_Binary_Tree_to_Linked_List;

import Chapter_7_trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        flatten(root, list);
        TreeNode temp = root;
        for (int i = 1; i < list.size(); i++) {
           temp.left = null;
           temp.right = list.get(i);
           temp = temp.right;
        }
    }

    public void flatten(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        flatten(root.left, list);
        flatten(root.right, list);
    }
}
