package TopInterview150.Chapter_1_Array_String.lc_17_13_Roman_to_Integer;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int romanToInt(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 'I' && chars[i] != 'X' && chars[i] != 'C') {
                result += map.get(chars[i]);
            } else if (i + 1 < chars.length) {
                if (chars[i] == 'I' && (chars[i + 1] == 'V' || chars[i + 1] == 'X')) {
                    result -= 1;
                } else if (chars[i] == 'X' && (chars[i + 1] == 'L' || chars[i + 1] == 'C')) {
                    result -= 10;
                } else if (chars[i] == 'C' && (chars[i + 1] == 'D' || chars[i + 1] == 'M')) {
                    result -= 100;
                } else {
                    result += map.get(chars[i]);
                }
            }
            else {
                result += map.get(chars[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.romanToInt("DCXXI");
    }
}
