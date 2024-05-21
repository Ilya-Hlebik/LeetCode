package LeetCode75.Chapter_9_Binary_Tree_DFS.lc_02_872_Leaf_Similar_Trees;

import Chapter_7_trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = leafSimilarHelper(root1, new ArrayList<>());
        List<Integer> list2 = leafSimilarHelper(root2, new ArrayList<>());
        if (list1.size()!= list2.size()){
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))){
                return false;
            }
        }
        return true;
    }

    public List<Integer> leafSimilarHelper(TreeNode root, List<Integer> list) {
        if (root == null){
            return list;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return list;
        }
        leafSimilarHelper(root.left, list);
        leafSimilarHelper(root.right, list);
        return list;
    }
}
