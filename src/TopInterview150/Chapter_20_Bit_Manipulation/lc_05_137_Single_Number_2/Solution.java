package TopInterview150.Chapter_20_Bit_Manipulation.lc_05_137_Single_Number_2;

public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
              res ^= nums[i];
        }
        return res ^1 ;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(new int[]{2,2,3,2}));
    }
}
