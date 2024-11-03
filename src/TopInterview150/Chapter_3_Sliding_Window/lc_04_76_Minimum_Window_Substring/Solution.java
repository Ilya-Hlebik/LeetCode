package TopInterview150.Chapter_3_Sliding_Window.lc_04_76_Minimum_Window_Substring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int finalStart = 0;
        int finalEnd = 0;
        int size = Integer.MAX_VALUE;
        int math = 0;
        int left = 0;
        for (int rigth = 0; rigth < s.length(); rigth++) {
            char letter = s.charAt(rigth);
            if (map.containsKey(letter)) {
                Integer integer = map.get(letter);
                map.put(letter, integer - 1);
                if (integer - 1 == 0) {
                    math++;
                }
            }
            while (math == map.size()) {
                if (rigth - left < size) {
                    finalStart = left;
                    finalEnd = rigth;
                    size = finalEnd - finalStart;
                }
                char leftLetter = s.charAt(left++);
                if (map.containsKey(leftLetter)){
                    Integer integer = map.get(leftLetter);
                    map.put(leftLetter, integer + 1);
                    if (integer+1>0){
                        math--;
                    }
                }
            }
        }
        return size == Integer.MAX_VALUE?"" : s.substring(finalStart, finalEnd+1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }
}
