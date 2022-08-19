package Interview_prepare;

public class BalanceBrackets {
    public static void main(String[] args) {

        BalanceBrackets sol = new BalanceBrackets();
        System.out.println(sol.balanceBrackets("{(({}))}"));
    }

    public String balanceBrackets(String input){
        int n = -1;
        while (input.length() != n) {
            n = input.length();
            input = input.replace("()", "");
            input = input.replace("[]", "");
            input = input.replace("{}", "");
        }
        return input.length() == 0? "Yes": "No";
    }
}
