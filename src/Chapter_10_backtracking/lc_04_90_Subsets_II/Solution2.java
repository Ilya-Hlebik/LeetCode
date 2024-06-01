package Chapter_10_backtracking.lc_04_90_Subsets_II;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        dfs(nums, result, new ArrayList<>(), 0);
        return result;
    }

    public void dfs(int[] nums, List<List<Integer>> result, List<Integer> temp, int start) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i> start && nums[i] == nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            dfs(nums, result, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
    public static void main(String[] args) {
        Solution2 solution = new  Solution2();
        System.out.println(solution.subsetsWithDup(new int[]{1, 2, 2}));
    }
}
