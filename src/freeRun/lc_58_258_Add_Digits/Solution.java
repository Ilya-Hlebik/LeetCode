package freeRun.lc_58_258_Add_Digits;

public class Solution {
    public int addDigits(int num) {
        int res = 0;
        if (num < 10) {
            return num;
        }
        while (num > 0) {
            res += num % 10;
            num = num / 10;
        }
        return addDigits(res);
    }
}
