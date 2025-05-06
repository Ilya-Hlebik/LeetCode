package Top100Liked.Chapter_15_Misc.lc_10_287_Find_the_Duplicate_Number;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)){
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {1, 3, 4, 2, 2};
        int res = 0;
        for (int anInt : ints) {
            res ^= anInt;
        }
        System.out.println(res);
    }
}
