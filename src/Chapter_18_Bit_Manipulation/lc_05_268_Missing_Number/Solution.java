package Chapter_18_Bit_Manipulation.lc_05_268_Missing_Number;

public class Solution {
    public static void main(String[] args) {

    }

    public int missingNumber(int[] nums) {
        int total = (nums.length * (nums.length + 1)) / 2;
        for (int num: nums){
            total-=num;
        }
        return total;
    }
}
