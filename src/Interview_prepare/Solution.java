package Interview_prepare;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMinElement(List.of(
                Map.of("gym", false,
                        "school", true,
                        "store", false),
                Map.of("gym", true,
                        "school", false,
                        "store", false),
                Map.of("gym", true,
                        "school", true,
                        "store", false),
                Map.of("gym", false,
                        "school", true,
                        "store", false),
                Map.of("gym", false,
                        "school", true,
                        "store", true)
        ), List.of("gym", "school", "store")));
    }

    private int getMinElement(List<Map<String, Boolean>> blocks, List<String> requirements) {
        int minDist = Integer.MAX_VALUE;
        int minElementIdex = 0;
        for (int i = 0; i < blocks.size(); i++) {
            Map<String, Boolean> currentBlock = blocks.get(i);
            List<String> whatWeNeed = requirements.stream().filter(key -> !currentBlock.get(key))
                    .collect(Collectors.toList());
            if (whatWeNeed.isEmpty()) {
                return i;
            }
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < blocks.size(); j++) {
                if (i == j) {
                    continue;
                }
                Map<String, Boolean> blockJ = blocks.get(j);
                for (String property : whatWeNeed) {
                    if (blockJ.get(property)) {
                        map.put(property, Math.min(map.getOrDefault(property, Math.abs(i - j)), Math.abs(i - j)));
                    }
                }
            }
            Optional<Integer> first = map.values().stream().max(Comparator.naturalOrder());
            if (first.isPresent()) {
                if (minDist > first.get()) {
                    minDist = first.get();
                    minElementIdex = i;
                }
            }
        }
        return minElementIdex;
    }
}

