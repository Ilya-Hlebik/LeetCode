package Top100Liked.Chapter_4_Dynamic_Programming.lc_12_300_Longest_Increasing_Subsequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                int index = Collections.binarySearch(list, nums[i]);
                if (index < 0) {
                    index = -(index + 1);
                }
                list.set(index, nums[i]);
            }
        }
        return list.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
