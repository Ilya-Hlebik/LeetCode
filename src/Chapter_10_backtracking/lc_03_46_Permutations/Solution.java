package Chapter_10_backtracking.lc_03_46_Permutations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0);
    }

    public List<List<Integer>> permute(int[] nums, int index) {
        List<List<Integer>> result = new ArrayList<>();
        if (index > nums.length - 1) {
            List<Integer> objects = new ArrayList<>();
            for (int num : nums) {
                objects.add(num);
            }
            result.add(objects);
            return result;
        }
        List<List<Integer>> permutes = permute(nums, index + 1);
        int element = nums[index];
        for (List<Integer> elem : permutes) {
            for (int i = 0; i < elem.size(); i++) {
                List<Integer> newElems = new ArrayList<>(elem);
                newElems.remove((Integer) element);
                newElems.add(i, element);
                result.add(newElems);
            }
        }
        return result.stream().distinct().collect(Collectors.toList());
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }
}
