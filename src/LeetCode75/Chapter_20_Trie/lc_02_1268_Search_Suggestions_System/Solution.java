package LeetCode75.Chapter_20_Trie.lc_02_1268_Search_Suggestions_System;

import java.util.*;

public class Solution {
    Trie root = new Trie();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie current = root;
        for (String product : products) {
            char[] productChars = product.toCharArray();
            for (char productChar : productChars) {
                if (!current.childs.containsKey(productChar)) {
                    current.childs.put(productChar, new Trie());
                }
                current = current.childs.get(productChar);
            }
            current.endWord = true;
            current.endValue = product;
            current = root;
        }
        List<List<String>> finalResult = new ArrayList<>();
        for (char searchChar : searchWord.toCharArray()) {
            if (current != null) {
                current = current.childs.get(searchChar);
            }
            if (current == null) {
                finalResult.add(new ArrayList<>());
                continue;
            }
            List<String> result = new ArrayList<>();
            if (current.endWord) {
                result.add(current.endValue);
            }
            dfs(current.childs, result);
            Collections.sort(result);
            if (result.size() > 3) {
                finalResult.add(result.subList(0, 3));
            } else {
                finalResult.add(result);
            }
        }

        return finalResult;
    }

    private void dfs(Map<Character, Trie> childs, List<String> result) {
        for (Trie value : childs.values()) {
            if (value.endWord) {
                result.add(value.endValue);
            }
            dfs(value.childs, result);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.suggestedProducts(new String[]{"havana"}, "tatiana"));
    }
}

class Trie {
    Map<Character, Trie> childs = new HashMap<>();
    String endValue;
    boolean endWord;
}
