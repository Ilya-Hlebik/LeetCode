package Chapter_18_Bit_Manipulation.lc_03_338_Counting_Bits;

public class Solution {
    public static void main(String[] args) {

    }

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < 32; j++) {
                count += ((1 << j) & i) == 0 ? 0 : 1;
            }
            res[i] = count;
        }
        return res;
    }
}
