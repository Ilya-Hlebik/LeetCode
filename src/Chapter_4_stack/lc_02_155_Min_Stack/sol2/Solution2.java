package Chapter_4_stack.lc_02_155_Min_Stack.sol2;

import java.util.Stack;

public class Solution2 {
    public static void main(String[] args) {
 /*       MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());*/
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

class MinStack {
    Stack<Integer> values = new Stack<>();
    Stack<Integer> minimums = new Stack<>();

    public MinStack() {
    }

    public void push(int val) {
        values.push(val);
        if (minimums.isEmpty() || minimums.peek() > val) {
            minimums.push(val);
        } else {
            minimums.push(minimums.peek());
        }
    }

    public void pop() {
        minimums.pop();
        values.pop();
    }

    public int top() {
        return values.peek();
    }

    public int getMin() {
        return minimums.peek();
    }
}
