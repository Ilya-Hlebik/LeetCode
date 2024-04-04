package Chapter_13_1_D_Dynamic_Programming.lc_11_300_Longest_Increasing_Subsequence;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int lis [] = new int[nums.length ];
        for (int i = lis.length - 1; i >= 0; i--) {
            lis[i] = 1;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]< nums[j]){
                    lis[i] = Math.max(lis[i], 1+ lis[j]);
                }
            }
        }
        return Arrays.stream(lis).max().getAsInt();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }
}
