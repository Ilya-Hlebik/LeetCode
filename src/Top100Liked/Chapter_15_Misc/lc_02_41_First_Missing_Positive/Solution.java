package Top100Liked.Chapter_15_Misc.lc_02_41_First_Missing_Positive;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                hashSet.add(num);
            }
        }
        for (int i = 1; i<Integer.MAX_VALUE; i++){
            if (!hashSet.contains(i)){
                return i;
            }
        }
        return -1;
    }
}
