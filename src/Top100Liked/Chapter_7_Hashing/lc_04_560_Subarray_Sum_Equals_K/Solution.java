package Top100Liked.Chapter_7_Hashing.lc_04_560_Subarray_Sum_Equals_K;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum[] = new int[nums.length + 1];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int count = 0;
        for (int start = 0; start < sum.length; start++) {
            for (int end = start + 1; end < sum.length; end++) {
                if (sum[end] - sum[start] == k){
                    count++;
                }
            }
        }
        return count;
    }
}
