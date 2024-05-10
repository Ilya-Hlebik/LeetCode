package Chapter_18_Bit_Manipulation.lc_07_7_Reverse_Integer;

public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();

    }
    public int reverse(int x) {
        boolean isNegative = x < 0;

        x = Math.abs(x);

        int num = 0;

        while (x > 0) {
            if (Integer.MAX_VALUE / 10 < num) return 0;

            num = 10 * num + x % 10;
            x /= 10;
        }

        return isNegative ? -num : num;
    }
}
