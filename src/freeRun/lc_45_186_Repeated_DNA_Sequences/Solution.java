package freeRun.lc_45_186_Repeated_DNA_Sequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return new ArrayList<>();
        }
        Set<String> result = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i = 0, j = 10; j <= s.length(); i++, j++) {
            String substring = s.substring(i, j);
            if (!result.contains(substring) && set.contains(substring)) {
                result.add(substring);
            } else {
                set.add(substring);
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
}
