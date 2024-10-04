package TopInterview150.Chapter_20_Bit_Manipulation.lc_05_137_Single_Number_2;

public class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                if (((1 << i) & num) != 0) {
                    sum++;
                }
            }
            sum %= 3;
            if (sum == 1) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }
}
