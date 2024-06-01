package Chapter_10_backtracking.lc_03_46_Permutations;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Solution3 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(nums, list, new LinkedHashSet<>());
        return list;
    }

    public void dfs(int[] nums, List<List<Integer>> list, Set<Integer> tempList) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int num : nums) {
            if (tempList.contains(num)) {
                continue;
            }
            tempList.add(num);
            dfs(nums, list, tempList);
            tempList.remove(num);
        }
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }
}
