package TopInterview150.Chapter_15_BackTracking.lc_03_46_Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, nums, new ArrayList<>());
        return result;
    }

    public void dfs(List<List<Integer>> result, int[] nums, List<Integer> current) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
        }
        for (int num : nums) {
            if (current.contains(num)) {
                continue;
            }
            current.add(num);
            dfs(result, nums, current);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }
}
