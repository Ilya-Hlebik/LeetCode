package TopInterview150.Chapter_5_HashMap.lc_04_242_Valid_Anagram;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = s.length()-1; i >= 0; i--) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for (int val : arr) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}
