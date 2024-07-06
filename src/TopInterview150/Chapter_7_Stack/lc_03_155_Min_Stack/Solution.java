package TopInterview150.Chapter_7_Stack.lc_03_155_Min_Stack;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

    }
}

class MinStack {
    Stack<int[]> stack = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        stack.push(new int[]{val, (stack.isEmpty() ? val : Math.min(val, stack.peek()[1]))});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
