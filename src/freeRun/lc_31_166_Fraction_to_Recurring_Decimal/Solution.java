package freeRun.lc_31_166_Fraction_to_Recurring_Decimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        long numeratorLong = numerator;
        long denominatorLong = denominator;
        if (numeratorLong < 0 & denominatorLong > 0 || numeratorLong > 0 && denominatorLong < 0) {
            result.append("-");
            numeratorLong = Math.abs(numeratorLong);
            denominatorLong = Math.abs(denominatorLong);
        }
        result.append(numeratorLong / denominatorLong);
        long remainder = numeratorLong % denominatorLong;
        if (remainder == 0) {
            return result.toString();
        }
        result.append(".");
        Map<Long, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int i = 0;
        while (remainder != 0) {
            if (map.containsKey(remainder)){
                Integer index = map.get(remainder);
                for (int j = 0; j < list.size(); j++) {
                    if (index == j){
                        result.append("(");
                    }
                    result.append(list.get(j));
                }
                result.append(")");
                return result.toString();
            }
            else {
                map.put(remainder, i++);
                remainder *= 10;
                long nextDigit = remainder / denominatorLong;
                remainder %= denominatorLong;
                list.add(String.valueOf(nextDigit));
            }
        }
        result.append(String.join("", list));
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fractionToDecimal(-2147483648
                , 1));
    }
}
