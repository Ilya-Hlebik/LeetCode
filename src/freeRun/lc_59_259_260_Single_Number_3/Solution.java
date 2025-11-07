package freeRun.lc_59_259_260_Single_Number_3;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }
        int setBit = xor & (-xor);
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & setBit) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.singleNumber(new int[]{1, 2, 1, 3, 2});
    }

}
