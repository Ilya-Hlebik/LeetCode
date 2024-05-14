package LeetCode75.Chapter_1_Array_String.lc_08_334_Increasing_Triplet_Subsequence;

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num < secondMin) {
                secondMin = num;
            } else if (num > secondMin) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.increasingTriplet(new int[]{1,1,-2,6}));
    }
}
