package Chapter_10_backtracking.lc_04_90_Subsets_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        return subsetsWithDup(nums, 0).stream().peek(Collections::sort).distinct().collect(Collectors.toList());
    }

    public List<List<Integer>> subsetsWithDup(int[] nums, int index) {
        List<List<Integer>> result;
        if (nums.length == index) {
            result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        } else {
            List<List<Integer>> subsets = subsetsWithDup(nums, index + 1);
            int num = nums[index];
            List<List<Integer>> moreSubsets = new ArrayList<>();
            for (List<Integer> subset : subsets) {
                List<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(num);
                moreSubsets.add(newSubset);
            }
            subsets.addAll(moreSubsets);
            return subsets;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsetsWithDup(new int[]{4,4,4,1,4}));
    }
}
