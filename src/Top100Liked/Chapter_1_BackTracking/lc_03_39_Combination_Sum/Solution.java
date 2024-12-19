package Top100Liked.Chapter_1_BackTracking.lc_03_39_Combination_Sum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(int[] candidates, int remain, List<Integer> temp, int index) {
        if (remain == 0) {
            result.add(new ArrayList<>(temp));
        }
        if (remain < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            temp.add(candidates[i]);
            dfs(candidates, remain - candidates[i], temp, i);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(new int[]{2, 3, 5}, 8));
    }
}
