package freeRun.lc_69_299_Bulls_and_Cows;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : secret.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                map.computeIfPresent(g,(character, integer) -> integer-1);
                countA++;
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            char g = guess.charAt(i);
            char s = secret.charAt(i);
           if (s != g&&map.containsKey(g)) {
                Integer count = map.get(g);
                if (count > 0) {
                    map.put(g, count - 1);
                    countB++;
                }
            }
        }
        return String.format("%dA%dB", countA, countB);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getHint("1122", "1222"));
    }
}
