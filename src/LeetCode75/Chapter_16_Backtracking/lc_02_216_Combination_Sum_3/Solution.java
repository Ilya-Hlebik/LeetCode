package LeetCode75.Chapter_16_Backtracking.lc_02_216_Combination_Sum_3;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(k, n, 1, new ArrayList<>(), result);
        return result;
    }

    public void dfs(int k, int n, int min, List<Integer> currentNumbers, List<List<Integer>> result) {
        if (n < 0) {
            return;
        }
        if (k == 0) {
            if (n == 0) {
                result.add(new ArrayList<>(currentNumbers));
            }
            return;
        }
        for (int i = min; i <= 9; i++) {
            currentNumbers.add(i);
            dfs(k - 1, n - i, i + 1, currentNumbers, result);
            currentNumbers.remove(currentNumbers.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum3(3, 9));
    }
}
