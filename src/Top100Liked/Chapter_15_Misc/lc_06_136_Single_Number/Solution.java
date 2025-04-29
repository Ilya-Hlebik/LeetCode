package Top100Liked.Chapter_15_Misc.lc_06_136_Single_Number;

import java.util.Arrays;

public class Solution {
    public int singleNumber(int[] nums) {
     return Arrays.stream(nums).reduce((a,b)-> a^b).getAsInt();
    }
}
