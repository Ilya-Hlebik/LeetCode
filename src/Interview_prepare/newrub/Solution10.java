package Interview_prepare.newrub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution10 {

    public List<Integer> findAnagrams(String s, String p) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (char c : p.toCharArray()) {
            map1[c - 'a']++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            map2[s.charAt(i) - 'a']++;
            if (i >= p.length() - 1) {
                compare(result, map1, map2, i - p.length() + 1);
                char previousKey = s.charAt(i - (p.length() - 1));
                map2[previousKey - 'a']--;
            }
        }
        return result;
    }

    private void compare(List<Integer> result, int[] map1,int[] map2, int i) {
        if (Arrays.equals(map1, map2)){
            result.add(i);
        }
    }

    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        System.out.println(solution10.findAnagrams("abab", "ab"));
    }

}
