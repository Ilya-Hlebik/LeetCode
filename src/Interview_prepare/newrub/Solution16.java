package Interview_prepare.newrub;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution16 {
    public String largestPalindromic(String num) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] chars = num.toCharArray();
        Character[] copy = new Character[chars.length];
        for (int i = 0; i < chars.length; i++) {
            copy[i] = chars[i];
        }
        Arrays.sort(copy, Collections.reverseOrder());
        for (char c : copy) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        if (map.size() == 1 && map.containsKey('0')) {
            return "0";
        }
        Integer single = null;
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (builder.length() == 0 && entry.getKey() == '0') {
                continue;
            }
            Integer value = entry.getValue();
            if (value >= 2) {
                while (value > 1) {
                    builder.append(entry.getKey());
                    value -= 2;
                }
            }
            if (entry.getValue() % 2 != 0) {
                if (single == null) {
                    single = Character.digit(entry.getKey(), 10);
                } else {
                    single = Math.max(single, Character.digit(entry.getKey(), 10));
                }
            }
        }
        String leftPart = builder.toString();
        String rightPart = builder.reverse().toString();
        if (single != null) {
            return leftPart + single + rightPart;
        }
        return leftPart + rightPart;
    }

    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        System.out.println(solution16.largestPalindromic("97231404236749078329522372611037933"));
    }
}
