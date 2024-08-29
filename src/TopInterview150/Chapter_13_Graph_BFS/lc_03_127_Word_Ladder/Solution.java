package TopInterview150.Chapter_13_Graph_BFS.lc_03_127_Word_Ladder;

import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> used = new HashSet<>();
        int count = 1;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (used.contains(word)) {
                    continue;
                }
                used.add(word);
                for (String s : wordList) {
                    if (diff(word, s) == 1) {
                        if (s.equals(endWord)) {
                            return count;
                        }
                        queue.add(s);
                    }
                }
            }
        }
        return 0;
    }

    public int diff(String first, String second) {
        int count = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                count++;
            }
            if (count > 1) {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")));
    }
}
