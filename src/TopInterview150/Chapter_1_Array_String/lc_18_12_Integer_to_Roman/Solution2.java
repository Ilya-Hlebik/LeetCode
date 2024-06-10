package TopInterview150.Chapter_1_Array_String.lc_18_12_Integer_to_Roman;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public String intToRoman(int num) {
        List<Map.Entry<Character, Integer>> map = new ArrayList<>();
        StringBuilder res = new StringBuilder();

        List<Integer> values = List.of(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
        List<String> roman = List.of("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");

        for (int i = 0; i < values.size(); i++) {
            Integer value = values.get(i);
            while (num - value >= 0) {
                res.append(roman.get(i));
                num -= value;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.intToRoman(3749));
    }
}
