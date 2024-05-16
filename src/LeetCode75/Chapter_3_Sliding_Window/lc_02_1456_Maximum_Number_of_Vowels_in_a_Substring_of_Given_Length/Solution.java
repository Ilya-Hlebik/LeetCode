package LeetCode75.Chapter_3_Sliding_Window.lc_02_1456_Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int l = 0;
        int r = 0;
        int count = 0;
        int max = 0;
        while (r < k - 1) {
            if (vowels.contains(s.charAt(r))) {
                count++;
            }
            r++;
        }
        while (r < s.length()) {
            if (vowels.contains(s.charAt(r))) {
                count++;
            }
            max = Math.max(count, max);
            if (vowels.contains(s.charAt(l))) {
                count--;
            }
            l++;
            r++;
        }
        return max;
    }
}
