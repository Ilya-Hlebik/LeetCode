package freeRun.lc_82_326_Power_of_Three;

public class Solution2 {
    public boolean isPowerOfThree(int n) {
        if (n==1){
            return true;
        }
        if (n <=0 || n%3 !=0){
            return false;
        }
        return isPowerOfThree(n/3);
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        System.out.println(solution.isPowerOfThree(2147483647));
    }
}
