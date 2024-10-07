package TopInterview150.Chapter_20_Bit_Manipulation.lc_06_201_Bitwise_AND_of_Numbers_Range;

public class Solution {

    public int rangeBitwiseAnd(int left, int right) {
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int leftBit = left & (1 << i);
            if (leftBit == (right & (1 << i))) {
                ans |= leftBit;
            } else {
                break;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rangeBitwiseAnd(1073741824, 2147483647));
    }
}
