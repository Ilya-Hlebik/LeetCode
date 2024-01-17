package arrays_and_strings.lc_01_217_Contains_Duplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public boolean containsDuplicate(int[] nums) {
        final Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
