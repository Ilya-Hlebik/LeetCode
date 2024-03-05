package Chapter_10_backtracking.lc_02_39_Combination_Sum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, 0, new ArrayList<>(), 0, target, result);
        return result;
    }

    public void dfs(int[] candidates, int index, List<Integer> current, int total, int target, List<List<Integer>> result) {
        if (total == target) {
            result.add(new ArrayList<>(current));
        } else if (index > candidates.length - 1 || total > target) {
        } else {
            current.add(candidates[index]);
            dfs(candidates, index, current, total + candidates[index], target, result);
            current.remove(current.size() - 1);
            dfs(candidates, index + 1, current, total, target, result);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(new int[]{7, 3, 2}, 18));
    }
}
