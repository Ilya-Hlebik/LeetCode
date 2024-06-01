package Interview_prepare.lc_01_47_Permutations_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        dfs(nums, result, new ArrayList<>(), new boolean[nums.length+1]);
        return new ArrayList<>(result);
    }
    private void dfs(int[] nums,Set<List<Integer>> result, List<Integer> temp, boolean used[]){
        if (temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i> 0 && nums[i] == nums[i-1] && !used[i-1]){
                    continue;
                }
                used[i] = true;
                temp.add(nums[i]);
                dfs(nums, result, temp,used);
                used[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}
