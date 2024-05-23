package Interview_prepare.newrub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution13 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int numI = nums[i];

            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int numsJ = nums[j];
                int numsK = nums[k];
                if ((numI + numsJ + numsK) == 0) {
                    result.add(List.of(numI, numsJ, numsK));
                    while (j < k && nums[k] == numsK) {
                        k--;
                    }
                    while (j < k && nums[j] == numsJ) {
                        j++;
                    }
                }
                else if ((numI + numsJ + numsK) > 0){
                    k--;
                }
                else if ((numI + numsJ + numsK) < 0){
                    j++;
                }
            }
        }
        return result;
    }
}
