package Chapter_1_arrays_and_strings.lc_01_217_Contains_Duplicate;

import java.util.Arrays;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }
}
