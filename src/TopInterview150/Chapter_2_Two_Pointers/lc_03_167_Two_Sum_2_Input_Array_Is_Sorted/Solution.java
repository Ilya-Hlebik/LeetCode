package TopInterview150.Chapter_2_Two_Pointers.lc_03_167_Two_Sum_2_Input_Array_Is_Sorted;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r  = numbers.length-1;
        while (l<r){
            if ((numbers[l] + numbers[r])> target){
                r--;
            }
            else if ((numbers[l] + numbers[r])< target){
                l++;
            }
            else {
                return  new int[]{l+1, r+1};
            }
        }
        return new int[]{-1, -1};
    }
}
