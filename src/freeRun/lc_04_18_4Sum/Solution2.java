package freeRun.lc_04_18_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, target, 0, new ArrayList<>(), result, 4);
        return result;
    }

    private void helper(int[] nums, long target, int start, List<Integer> temp, List<List<Integer>> result, int needNumbers) {
        if (needNumbers > 2) {
            for (int a = start; a < nums.length; a++) {
                if (a > start && nums[a] == nums[a - 1]) {
                    continue;
                }
                temp.add(nums[a]);
                helper(nums, target - nums[a], a + 1, temp, result, needNumbers - 1);
                temp.remove(temp.size() - 1);
            }
        } else {
            int c = start;
            int d = nums.length - 1;
            while (c < d) {
                long sum = (long) nums[c] + nums[d];
                if (sum > target) {
                    d--;
                } else if (sum < target) {
                    c++;
                } else {
                    temp.add(nums[c]);
                    temp.add(nums[d]);
                    result.add(new ArrayList<>(temp));
                    c++;
                    d--;
                    temp.remove(temp.size() - 1);
                    temp.remove(temp.size() - 1);
                    while (c < d && nums[c] == nums[c - 1]) {
                        c++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
    }
}
