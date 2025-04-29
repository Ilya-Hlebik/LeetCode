package Top100Liked.Chapter_15_Misc.lc_07_169_Majority_Element;

public class Solution2 {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num != candidate) {
                count--;
            }
            else {
                count++;
            }
        }
        return candidate;
    }
}
