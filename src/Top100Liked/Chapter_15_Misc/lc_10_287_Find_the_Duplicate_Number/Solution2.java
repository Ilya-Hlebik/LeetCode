package Top100Liked.Chapter_15_Misc.lc_10_287_Find_the_Duplicate_Number;

public class Solution2 {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do { // we are sure that at least one duplicate is there
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);
        // find the head of loop
        fast = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] ints = {1, 3, 4, 2, 2};
        int res = 0;
        for (int anInt : ints) {
            res ^= anInt;
        }
        System.out.println(solution.findDuplicate(ints));
    }
}
