package Chapter_18_Bit_Manipulation.lc_04_190_Reverse_Bits;

public class Solution {
    public int reverseBits(int n) {
        int res = Integer.MAX_VALUE;
        for (int i = 31, j =0; i > 0; i--, j++) {
            if (((1 << i) & n) == 0) {
                res = res & ~(1 << j);
            } else {
                res = res | (1 << j);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseBits(43261596));
    }
}
