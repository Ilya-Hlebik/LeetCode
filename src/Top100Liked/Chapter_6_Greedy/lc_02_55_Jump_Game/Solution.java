package Top100Liked.Chapter_6_Greedy.lc_02_55_Jump_Game;

public class Solution {
    public boolean canJump(int[] nums) {
        int currentTarget = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= currentTarget) {
                currentTarget = i;
            }
        }
        return currentTarget == 0;
    }
}
