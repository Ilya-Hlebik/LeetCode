package Chapter_18_Bit_Manipulation.lc_07_7_Reverse_Integer;

public class Solution2 {
    public int reverse(int x) {
        boolean isNegative = x < 0;
        if (isNegative) {
            x = Math.abs(x);
            if (x<0){
                return 0;
            }
        }
        long value = Long.parseLong((isNegative ? "-" : "") + new StringBuilder(String.valueOf(x)).reverse().toString());
        if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE){
            return 0;
        }
        return (int) value;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.reverse(-1563847412));
    }
}
