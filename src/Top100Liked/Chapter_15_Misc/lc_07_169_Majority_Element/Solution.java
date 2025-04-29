package Top100Liked.Chapter_15_Misc.lc_07_169_Majority_Element;

import java.util.Arrays;

public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
