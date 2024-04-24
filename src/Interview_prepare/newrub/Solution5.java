package Interview_prepare.newrub;

public class Solution5 {
    int[] w;
    int total;

    public Solution5(int[] w) {
        int total = 0;
        for (int i = 0; i < w.length; i++) {
            total += w[i];
            w[i] = total;
        }
        this.w = w;
        this.total = total;
    }

    public int pickIndex() {
        int randomNumber = (int) (Math.random() * (total));
        int left = 0;
        int right = w.length - 1;
        while (right > left) {
            int mid = left + (right - left) / 2;
            if (randomNumber < w[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5(new int[]{1});
        System.out.println(solution5.pickIndex());
    }
}
