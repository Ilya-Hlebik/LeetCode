package Top100Liked.Chapter_15_Misc.lc_02_41_First_Missing_Positive;

public class Solution2 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0 &&  num-1<nums.length && nums[num - 1]!=num) {
                int temp = nums[num - 1];
                nums[num - 1] = num;
                nums[i] = temp;
                i--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.firstMissingPositive(new int[]{1, 2, 0}));
    }
}
