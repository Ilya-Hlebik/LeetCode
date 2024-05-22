package LeetCode75.Chapter_11_Binary_Search_Tree.lc_02_450_Delete_Node_in_a_BST;

import Chapter_7_trees.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }
        List<Integer> arrayFromNodes = getArrayFromNodes(root, key, new ArrayList<>());
        Collections.sort(arrayFromNodes);
        return constructBST(arrayFromNodes, 0, arrayFromNodes.size()-1);
    }

    private TreeNode constructBST(List<Integer> arrayFromNodes, int min, int max) {
        if (min> max){
            return null;
        }
        int mid = min + (max - min)/2;
        TreeNode root = new TreeNode(arrayFromNodes.get(mid));
        root.left = constructBST(arrayFromNodes, min, mid-1);
        root.right = constructBST(arrayFromNodes, mid+1, max);
        return root;
    }

    private List<Integer> getArrayFromNodes(TreeNode root, int key, List<Integer> values) {
        if (root == null) {
            return values;
        }
        if (root.val != key) {
            values.add(root.val);
        }
        getArrayFromNodes(root.left, key, values);
        getArrayFromNodes(root.right, key, values);

        return values;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(0);
        solution.deleteNode(root, 0);
    }
}
