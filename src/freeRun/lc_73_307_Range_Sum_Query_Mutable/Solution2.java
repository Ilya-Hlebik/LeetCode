package freeRun.lc_73_307_Range_Sum_Query_Mutable;

public class Solution2 {
    static class NumArray {
        int tree[];
        int n;

        public NumArray(int[] nums) {
            this.n = nums.length;
            this.tree = new int[2 * n];
            for (int i = 0; i < nums.length; i++) {
                tree[i + n] = nums[i];
            }

            for (int i = n - 1; i > 0; i--) {
                tree[i] = tree[i * 2] + tree[i * 2 + 1];
            }
        }

        public void update(int index, int val) {
            int pos = index + n;
            tree[pos] = val;
            while (pos > 0) {
                pos /= 2;
                tree[pos] = tree[pos * 2] + tree[pos * 2 + 1];
            }
        }

        public int sumRange(int left, int right) {
            left += n;
            right += n;
            int sum = 0;
            while (left <= right) {
                if (tree[left] % 2 != 0) {
                    sum += tree[left++];
                }
                if (tree[right] % 2 == 0) {
                    sum += tree[right--];
                }
                left /= 2;
                right /= 2;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5, 7});
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, -1);
        numArray.update(2, 3);
        numArray.update(0, 5);
        System.out.println(numArray.sumRange(0, 2));


    }
}
