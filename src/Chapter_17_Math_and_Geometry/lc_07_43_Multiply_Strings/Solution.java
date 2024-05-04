package Chapter_17_Math_and_Geometry.lc_07_43_Multiply_Strings;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] temp = new int[num1.length() + num2.length()];
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        for (int i1 = 0; i1 < num1.length(); i1++) {
            for (int i2 = 0; i2 < num2.length(); i2++) {
                int digit = Character.digit(num1.charAt(i1), 10) * Character.digit(num2.charAt(i2), 10);
                temp[i1 + i2] += digit;
                temp[i1 + i2 + 1] += temp[i1 + i2] / 10;
                temp[i1 + i2] = temp[i1 + i2] % 10;
            }
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = temp.length - 1, j = 0; i >= 0; i--, j++) {
            res[j] = temp[i];
        }
        int begin = 0;
        int i = 0;
        while (res[i] == 0) {
            begin++;
            i++;
        }
        return Arrays.stream(Arrays.copyOfRange(res, begin, res.length)).mapToObj(String::valueOf).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("123", "456"));
    }
}
