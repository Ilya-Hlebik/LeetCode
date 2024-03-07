package Chapter_10_backtracking.lc_05_40_Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (Arrays.stream(candidates).sum() < target) {
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        List<List<Integer>> combinations = getCombinations(candidates, 0, target);
        return combinations.stream()
                .filter(integers -> integers.stream().mapToInt(i -> i).sum() == target)
                .collect(Collectors.toList());
    }

    public List<List<Integer>> getCombinations(int[] candidates, int index, int target) {
        List<List<Integer>> result;
        if (index == candidates.length) {
            result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        } else {
            result = getCombinations(candidates, index + 1, target);
            int newElement = candidates[index];
            if (newElement > target) {
                return result;
            }
            List<List<Integer>> moreCombinations = new ArrayList<>();
            for (List<Integer> list : result) {
                List<Integer> newCombs = new ArrayList<>(list);
                list.add(newElement);
                moreCombinations.add(newCombs);
            }
            result.addAll(moreCombinations);
            return result.stream()
                    .filter(integers -> integers.stream().mapToInt(i -> i).sum() <= target)
                    .distinct()
                    .collect(Collectors.toList());
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum2(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 30));
    }
}
