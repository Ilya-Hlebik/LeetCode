package Top100Liked.Chapter_1_BackTracking.lc_04_46_Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, List<Integer> temp) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int num : nums) {
                if (!temp.contains(num)) {
                    temp.add(num);
                    dfs(nums, temp);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }
}
