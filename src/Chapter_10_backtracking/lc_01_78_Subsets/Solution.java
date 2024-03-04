package Chapter_10_backtracking.lc_01_78_Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0);
    }

    public List<List<Integer>> subsets(int[] nums, int index) {
        List<List<Integer>> result;
        if (index == nums.length){
            result = new ArrayList<>();
            result.add(new ArrayList<>());
        }
        else {
             result = subsets(nums, index + 1);
            int item = nums[index];
            List<List<Integer>> moreSubsets = new ArrayList<>();
            for (List<Integer> resultElements : result) {
                List<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(resultElements);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            result.addAll(moreSubsets);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
    }
}
