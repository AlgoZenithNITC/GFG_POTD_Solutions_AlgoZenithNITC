// Java program to implement a stack that supports
// all operations in O(1) time and O(n) extra space.

import java.util.Stack;

class SpecialStack {
    private Stack<int[]> s;

    public SpecialStack() {
        s = new Stack<>();
    }

    // Add an element to the top of Stack
    public void push(int x) {
        int newMin = s.isEmpty() ? x : Math.min(x, s.peek()[1]);
        s.push(new int[]{x, newMin});
    }

    // Remove the top element from the Stack
    public void pop() {
        if (!s.isEmpty()) {
            s.pop();
        }
    }

    // Returns top element of the Stack
    public int peek() {
        return s.isEmpty() ? -1 : s.peek()[0];
    }

    // Finds minimum element of Stack
    public int getMin() {
        return s.isEmpty() ? -1 : s.peek()[1];
    }

    public static void main(String[] args) {
        SpecialStack ss = new SpecialStack();

        // Function calls
        ss.push(2);
        ss.push(3);
        System.out.print(ss.peek() + " ");
        ss.pop();
        System.out.print(ss.getMin() + " ");
        ss.push(1);
        System.out.print(ss.getMin() + " ");
    }
}