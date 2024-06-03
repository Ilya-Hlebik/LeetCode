package Chapter_10_backtracking.lc_02_39_Combination_Sum;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, result, new ArrayList<>(),0);
        return result;
    }

    private void dfs(int[] candidates, int remain, List<List<Integer>> result, List<Integer> tempList, int start) {
        if (remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        if (remain < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            dfs(candidates, remain - candidates[i], result, tempList, i);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
