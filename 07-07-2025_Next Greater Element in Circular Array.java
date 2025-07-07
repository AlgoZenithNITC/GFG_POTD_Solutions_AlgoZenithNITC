class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = -1;
        }

        Stack<Integer> stk = new Stack<>();

        // Traverse the array from right to left
        for (int i = 2 * n - 1; i >= 0; i--) {
            int curr = arr[i % n];

            // Pop elements smaller
            // than or equal to current
            while (!stk.isEmpty() && stk.peek() <= curr) {
                stk.pop();
            }

            // Assign next greater
            // if within first pass
            if (i < n && !stk.isEmpty()) {
                res[i] = stk.peek();
            }

            stk.push(curr);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int val : res) {
            result.add(val);
        }

        return result;
    }
}