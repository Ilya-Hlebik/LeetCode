package Chapter_1_arrays_and_strings.lc_02_242_Valid_Anagram;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[128];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
            arr[t.charAt(i)]--;
        }
        for (int value : arr) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
