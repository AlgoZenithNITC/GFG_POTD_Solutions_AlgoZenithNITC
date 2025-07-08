import java.util.*;

class Solution {
    public int[] findGreater(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Map<Integer, Integer> freq = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Step 1: Count frequency of each element
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            int currentFreq = freq.get(arr[i]);

            // Pop elements from stack with freq <= current element's freq
            while (!stack.isEmpty() && freq.get(stack.peek()) <= currentFreq) {
                stack.pop();
            }

            // If stack is not empty, top element is the answer
            res[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push current element to stack
            stack.push(arr[i]);
        }

        return res;
    }
}
