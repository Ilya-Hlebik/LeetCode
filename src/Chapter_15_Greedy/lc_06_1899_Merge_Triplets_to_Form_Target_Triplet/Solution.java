package Chapter_15_Greedy.lc_06_1899_Merge_Triplets_to_Form_Target_Triplet;

public class Solution {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean firstEqual = false;
        boolean secondEqual = false;
        boolean thirdEqual = false;
        for (int[] triplet : triplets) {
            if (triplet[0] <= target[0] && triplet[1] <= target[1] & triplet[2] <= target[2]) {
                if (triplet[0] == target[0]){
                    firstEqual = true;
                }
                if (triplet[1] == target[1]){
                    secondEqual = true;
                }
                if (triplet[2] == target[2]){
                    thirdEqual = true;
                }
            }
        }
        return firstEqual && secondEqual && thirdEqual;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mergeTriplets(new int[][]{{2, 5, 3}, {1, 8, 4}, {1, 7, 5}}, new int[]{2, 7, 5}));
    }

}
