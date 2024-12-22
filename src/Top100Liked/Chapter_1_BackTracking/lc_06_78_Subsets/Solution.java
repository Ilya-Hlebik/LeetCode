package Top100Liked.Chapter_1_BackTracking.lc_06_78_Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(int[] nums, List<Integer> temp, int index) {
        result.add(new ArrayList<>(temp));
        if (index>nums.length-1){
            return;
        }
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(nums, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsets(new int[]{0}));
    }
}
