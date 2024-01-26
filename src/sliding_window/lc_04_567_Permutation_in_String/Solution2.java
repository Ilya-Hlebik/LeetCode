package sliding_window.lc_04_567_Permutation_in_String;

import java.util.Arrays;

public class Solution2 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] charsS1 = new int[26];
        for (char charS1 : s1.toCharArray()) {
            charsS1[charS1 - 'a']++;
        }
        int[] charsS2 = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            charsS2[s2.charAt(i) - 'a']++;
            if (i >= s1.length()) {
                charsS2[s2.charAt(i - s1.length()) - 'a']--;
            }
            if (Arrays.equals(charsS1, charsS2)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.checkInclusion("ab", "eidbaooo"));
        System.out.println(solution.checkInclusion("ab", "eidboaoo"));
        System.out.println(solution.checkInclusion("adc", "dcda"));
        System.out.println(solution.checkInclusion("hello", "ooolleoooleh"));
    }
}
