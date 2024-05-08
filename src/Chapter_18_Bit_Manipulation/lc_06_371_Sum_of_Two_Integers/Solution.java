package Chapter_18_Bit_Manipulation.lc_06_371_Sum_of_Two_Integers;

public class Solution {
    public int getSum(int a, int b) {
        int res = 0;
        int temp = 0;
        for (int i = 0; i < 32; i++) {
            if ((a & (1 << i)) == 0 && (b & (1 << i)) == 0) {
                if (temp == 0) {
                    continue;
                }
                res |= (1 << i);
                temp = 0;
            } else if ((a & (1 << i)) != 0 && (b & (1 << i)) == 0 || (a & (1 << i)) == 0 && (b & (1 << i)) != 0) {
                if (temp == 0) {
                    res |= (1 << i);
                }
            } else {
                if (temp == 0) {
                    temp = 1;
                } else {
                    res |= (1 << i);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getSum(3, 3));

    }
}
