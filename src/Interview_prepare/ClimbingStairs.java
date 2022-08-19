package Interview_prepare;

/*You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/
public class ClimbingStairs {
    public int climbStairs(int n) {
        int num1 = 0, num2 = 1;

        for (int counter = 0; counter < n; counter++) {
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
        }
        return num2;
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(5));
    }
}
