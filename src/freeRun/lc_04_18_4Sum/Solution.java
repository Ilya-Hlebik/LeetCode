package freeRun.lc_04_18_4Sum;

import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int a = 0; a < nums.length; a++) {
            for (int b = a + 1; b < nums.length; b++) {
                int c = b + 1;
                int d = nums.length - 1;
                while (c < d) {
                    long sum =(long) nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum > target) {
                        d--;
                    } else if (sum < target) {
                        c++;
                    } else {
                        result.add(List.of(nums[a], nums[b], nums[c], nums[d]));
                        c++;
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
    }
}
