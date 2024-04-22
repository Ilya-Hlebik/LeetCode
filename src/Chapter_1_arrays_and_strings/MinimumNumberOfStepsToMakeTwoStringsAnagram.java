package Chapter_1_arrays_and_strings;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/*You are given two strings of the same length s and t. In one step you can choose any character of t and replace it with another character.

Return the minimum number of steps to make t an anagram of s.

An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.



Example 1:

Input: s = "bab", t = "aba"
Output: 1
Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
Example 2:

Input: s = "leetcode", t = "practice"
Output: 5
Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
Example 3:

Input: s = "anagram", t = "mangaar"
Output: 0
Explanation: "anagram" and "mangaar" are anagrams. */
public class MinimumNumberOfStepsToMakeTwoStringsAnagram {
    public int minSteps(String s, String t) {
        AtomicInteger res = new AtomicInteger();
        HashMap<String, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String key = String.valueOf(t.charAt(i));
            tMap.computeIfPresent(key, (s1, integer) -> ++integer);
            tMap.putIfAbsent(key, 1);
        }
        for (int i = 0; i < s.length(); i++) {
            String currentS = String.valueOf(s.charAt(i));
            AtomicBoolean isPresent = new AtomicBoolean(false);
            tMap.computeIfPresent(currentS, (s1, integer) -> {
                isPresent.set(true);
                if (integer == 0) {
                    res.getAndIncrement();
                } else {
                    integer--;
                }
                return integer;
            });
            if (!isPresent.get()) {
                res.getAndIncrement();
            }
        }
        return res.get();
    }

    public static void main(String[] args) {
        MinimumNumberOfStepsToMakeTwoStringsAnagram minimumNumberOfStepsToMakeTwoStringsAnagram = new MinimumNumberOfStepsToMakeTwoStringsAnagram();
        System.out.println(minimumNumberOfStepsToMakeTwoStringsAnagram.minSteps("bab", "aba"));
        System.out.println(minimumNumberOfStepsToMakeTwoStringsAnagram.minSteps("leetcode", "practice"));
        System.out.println(minimumNumberOfStepsToMakeTwoStringsAnagram.minSteps("anagram", "mangaar"));
    }
}
