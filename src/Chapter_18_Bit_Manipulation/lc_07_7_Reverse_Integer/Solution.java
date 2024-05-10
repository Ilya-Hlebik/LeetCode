package Chapter_18_Bit_Manipulation.lc_07_7_Reverse_Integer;

public class Solution {
    public int reverse(int x) {
        boolean isNegative = x < 0;
        try {
            if (isNegative) {
                x = Math.abs(x);
            }
            return Integer.parseInt((isNegative ? "-" : "") + new StringBuilder(String.valueOf(x)).reverse().toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(-123));
    }
}
