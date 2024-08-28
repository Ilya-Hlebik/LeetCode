package TopInterview150.Chapter_13_Graph_BFS.lc_02_433_Minimum_Genetic_Mutation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        Set<String> used = new HashSet<>();
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String gene = queue.poll();
                if (used.contains(gene)) {
                    continue;
                }
                used.add(gene);
                for (String s : bank) {
                    if (diff(gene, s) == 1) {
                        if (s.equals(endGene)) {
                            return ++count;
                        }
                        queue.add(s);
                    }
                }
            }
            count++;
        }
        return -1;
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
        System.out.println(solution.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
    }
}
