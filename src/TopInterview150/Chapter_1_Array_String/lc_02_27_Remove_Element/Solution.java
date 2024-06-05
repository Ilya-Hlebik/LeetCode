package TopInterview150.Chapter_1_Array_String.lc_02_27_Remove_Element;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = -1;
                count++;
            }
        }
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (l+ count == nums.length){
                break;
            }
            if (nums[l] == -1){
                while (r>0 && nums[r] == -1){
                    r--;
                }
                nums[l] = nums[r];
                nums[r] = -1;
            }
            l++;
        }
        return nums.length-count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.removeElement(new int[]{2,2,3}, 2);
    }
}
