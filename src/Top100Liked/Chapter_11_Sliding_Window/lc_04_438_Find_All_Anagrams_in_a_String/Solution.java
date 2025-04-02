package Top100Liked.Chapter_11_Sliding_Window.lc_04_438_Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] map = new int[26];
        for (char c : p.toCharArray()) {
            map[c - 'a']++;
        }
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i > p.length() - 1) {
                map[s.charAt(i - p.length()) - 'a']++;
            }
            map[charArray[i] - 'a']--;
            boolean loverOrEqualZero = true;
            for (int count : map) {
                if (count > 0) {
                    loverOrEqualZero = false;
                    break;
                }
            }
            if (loverOrEqualZero) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAnagrams("abab", "ab"));

    }
}
