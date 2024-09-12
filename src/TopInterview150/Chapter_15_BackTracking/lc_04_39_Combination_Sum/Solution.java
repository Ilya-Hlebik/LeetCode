package TopInterview150.Chapter_15_BackTracking.lc_04_39_Combination_Sum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, result, new ArrayList<>(), target, 0);
        return result;
    }

    public void dfs(int[] candidates, List<List<Integer>> result, List<Integer> current, int remain, int start) {
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (remain < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            dfs(candidates, result, current, remain - candidates[i], i);
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
