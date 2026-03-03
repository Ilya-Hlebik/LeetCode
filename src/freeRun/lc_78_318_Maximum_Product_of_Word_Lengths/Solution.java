package freeRun.lc_78_318_Maximum_Product_of_Word_Lengths;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Solution {
    Map<String, int[]> memo = new HashMap<>();

    public int maxProduct(String[] words) {
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            String firstCandidate = words[i];
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }
                String secondCandidate = words[j];
                if (firstCandidate.length() * secondCandidate.length() > result && notContainsSameLetters(firstCandidate, secondCandidate)) {
                    result = firstCandidate.length() * secondCandidate.length();
                }
            }
        }
        return result;
    }

    private boolean notContainsSameLetters(String firstCandidate, String secondCandidate) {
        int[] firstArray = memo.computeIfAbsent(firstCandidate, createArrayForComparison(firstCandidate));
        int[] secondArray = memo.computeIfAbsent(secondCandidate, createArrayForComparison(secondCandidate));
        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] > 0 && secondArray[i] > 0) {
                return false;
            }
        }
        return true;
    }

    private static Function<String, int[]> createArrayForComparison(String secondCandidate) {
        return s -> {
            int[] temp = new int[26];
            for (int i = 0; i < secondCandidate.length(); i++) {
                temp[secondCandidate.charAt(i) - 'a']++;
            }
            return temp;
        };
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"});
    }

}
