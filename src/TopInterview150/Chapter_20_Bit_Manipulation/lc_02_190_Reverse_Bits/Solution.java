package TopInterview150.Chapter_20_Bit_Manipulation.lc_02_190_Reverse_Bits;

public class Solution {
    public int reverseBits(int n) {
        int temp = 0;
        for (int i = 0, j = 31; i <= 31; i++, j--) {
            temp |= ((1 << i & n) != 0 ? 1 : 0) << j;
        }
        return temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Integer.parseUnsignedInt(""));
    }
}
