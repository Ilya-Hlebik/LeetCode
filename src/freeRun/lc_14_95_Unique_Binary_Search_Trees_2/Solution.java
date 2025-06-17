package freeRun.lc_14_95_Unique_Binary_Search_Trees_2;

import Chapter_7_trees.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<String, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }

    public List<TreeNode> dfs(int start, int end) {
        String key = start +"-" + end;
        if (map.containsKey(key)){
            return map.get(key);
        }
        List<TreeNode> results = new ArrayList<>();
        if (start> end){
            results.add(null);
            return results;
        }
        for (int rootVal = start; rootVal<=end; rootVal++){
            List<TreeNode> lefts = dfs(start, rootVal - 1);
            List<TreeNode> rights = dfs(rootVal + 1, end);

            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(rootVal, left, right);
                    results.add(root);
                }
            }
        }
        map.put(key,results);
        return results;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generateTrees(3);
    }
}
