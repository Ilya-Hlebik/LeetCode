package Chapter_6_linked_list.lc_08_287_Find_the_Duplicate_Number;

public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while (slow!=fast);
        int slow2= 0;
        while (slow2!= slow){
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        return slow2;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }
}
