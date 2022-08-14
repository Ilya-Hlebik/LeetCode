package arrays_and_strings;

import java.util.*;
/*Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]*/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        List<Integer> excludeIndexes = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (excludeIndexes.contains(i)) {
                continue;
            }
            int[] letters = new int[26];
            String currentI = strs[i];
            for (int k = 0; k < currentI.length(); k++) {
                letters[currentI.charAt(k) - 'a']++;
            }
            ArrayList<String> e = new ArrayList<>();
            result.add(e);
            e.add(currentI);
            for (int j = 0; j < strs.length; j++) {
                String currentJ = strs[j];
                if (i == j || currentI.length() != currentJ.length()) {
                    continue;
                }
                int[] copyLetters = Arrays.copyOf(letters, letters.length);
                for (int k = 0; k < currentI.length(); k++) {
                    copyLetters[currentJ.charAt(k) - 'a']--;
                }
                boolean anagram = true;
                for (int copyLetter : copyLetters) {
                    if (copyLetter != 0) {
                        anagram = false;
                        break;
                    }
                }
                if (anagram) {
                    excludeIndexes.add(j);
                    e.add(currentJ);
                }
            }

        }
        return result;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] hash = new char[26];

            for (int j = 0; j < str.length(); j++) {
                hash[str.charAt(j) - 'a']++;
            }
            String hashCode = String.valueOf(hash);
            map.computeIfAbsent(hashCode, k -> new ArrayList<>());
            map.computeIfPresent(hashCode, (s, strings) -> {
                strings.add(str);
                return strings;
            });
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams1(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams.groupAnagrams(new String[]{""}));
        System.out.println(groupAnagrams.groupAnagrams(new String[]{"a"}));
    }
}
