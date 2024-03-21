package Chapter_11_graphs.lc_13_127_Word_Ladder;

import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Map<String, List<String>> nei = new HashMap<>();
        wordList.add(0, beginWord);
        for (String word : wordList) {
            for (int j = 0; j < word.length(); j++) {
                StringBuilder pattern = new StringBuilder(word);
                pattern.setCharAt(j, '*');
                List<String> orDefault = nei.getOrDefault(pattern.toString(), new ArrayList<>());
                orDefault.add(word);
                nei.put(pattern.toString(), orDefault);
            }
        }
        Set<String> visit = new HashSet<>();
        visit.add(beginWord);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int res = 1;
        while (!q.isEmpty()) {
            res++;
           int  size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                for (int j = 0; j < word.length(); j++) {
                    StringBuilder pattern = new StringBuilder(word);
                    pattern.setCharAt(j, '*');
                    for (String neiWord : nei.get(pattern.toString())) {
                        if (neiWord.equals(endWord)) {
                            return res;
                        }
                        if (!visit.contains(neiWord)) {
                            visit.add(neiWord);
                            q.add(neiWord);
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<String> objects = new ArrayList<>();
        objects.add("hot");
        objects.add("dot");
        objects.add("dog");
        objects.add("lot");
        objects.add("log");
        objects.add("cog");
        System.out.println(solution.ladderLength("hit", "cog", objects));

    }
}
