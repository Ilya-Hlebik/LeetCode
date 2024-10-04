package TopInterview150.Chapter_20_Bit_Manipulation.lc_06_201_Bitwise_AND_of_Numbers_Range;

public class Solution {

    public int rangeBitwiseAnd(int left, int right) {
        int ans = left;
        for (int i = left + 1; i <= right && ans != 0 && i <Integer.MAX_VALUE && i>=0; i++) {
            ans &= i;
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rangeBitwiseAnd(1073741824, 2147483647));
    }
}
