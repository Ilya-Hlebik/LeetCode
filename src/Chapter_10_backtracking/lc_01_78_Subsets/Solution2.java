package Chapter_10_backtracking.lc_01_78_Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        dfs(nums, result, new ArrayList<>(), 0);
        return result;
    }

    public void dfs(int[] nums, List<List<Integer>> result, List<Integer> temp, int start) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(nums, result, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
    }
}
