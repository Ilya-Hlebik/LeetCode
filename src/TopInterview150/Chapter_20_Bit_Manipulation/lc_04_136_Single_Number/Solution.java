package TopInterview150.Chapter_20_Bit_Manipulation.lc_04_136_Single_Number;

public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^=num;
        }
        return res;
    }
}
