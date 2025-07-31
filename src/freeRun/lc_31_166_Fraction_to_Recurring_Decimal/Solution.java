package freeRun.lc_31_166_Fraction_to_Recurring_Decimal;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        double devide = (double) numerator / denominator;
        String temp = String.valueOf(devide);
        StringBuilder result = new StringBuilder();
        String split[] = temp.split("\\.");
        if (split[1].equals("0")) {
            return split[0];
        }



        int i = 0;
        while (temp.charAt(i++) != '.') {
        }
        return temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fractionToDecimal(2, 1));
    }
}
