package freeRun.lc_02_8_String_to_Integer_atoi;

public class Solution {
    public int myAtoi(String s) {
        if (s.isEmpty()){
            return 0;
        }
        boolean positive = true;
        double result = 0;
        int index = 0;
        while (index< s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (!Character.isDigit(s.charAt(index))) {
            char temp = s.charAt(index);
            if (temp == '-') {
                positive = false;
            } else if (temp != '+') {
                return 0;
            }
            index++;
        }
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                result = (result * 10) + (c - '0');
            } else {
                break;
            }
        }
        result = positive ? result : result * (-1);
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("   -042"));
    }
}
