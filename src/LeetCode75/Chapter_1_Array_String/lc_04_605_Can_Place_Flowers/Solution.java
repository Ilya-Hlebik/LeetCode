package LeetCode75.Chapter_1_Array_String.lc_04_605_Can_Place_Flowers;

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (flowerbed[i] != 1 && (i == 0 || flowerbed[i - 1] != 1) && (i + 1 == flowerbed.length || flowerbed[i + 1] != 1)) {
                n--;
                flowerbed[i] = 1;
            }
        }
        return n == 0;
    }
}
