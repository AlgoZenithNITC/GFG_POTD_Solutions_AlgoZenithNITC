// Class declaration
class Solution {

    // Declaration of variables
    public ArrayList<ArrayList<Integer>> result; // Stores the final result
    public int[] row = new int[10];              // Stores the row positions of queens
    public int k = 0;                            // Counter for number of solutions

    // Function to check if a queen can be placed at a particular position
    public boolean place(int r, int c) {
        // Checking if there is any queen in the same row or in diagonal positions
        for (int prev = 0; prev < c; prev++)
            if (row[prev] == r ||
                (int)Math.abs(row[prev] - r) == (int)Math.abs(prev - c))
                return false;
        return true;
    }

    // Backtracking function to find all possible solutions
    public void bt(int c, int n) {
        // Pruning - if n is 2 or 3, no solutions exist
        if (n == 2 || n == 3) return;

        // If all queens have been placed, add the solution to the result
        if (c == n) {
            ArrayList<Integer> v = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) v.add(row[i] + 1);
            result.add(v);
            k++;
        }

        // Recursive placement of queens
        for (int i = 0; i < n; i++) {
            if (place(i, c)) {
                row[c] = i;
                bt(c + 1, n);
            }
        }
    }

    // Main function to find all possible solutions for the N-Queens problem
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // Initialize result
        result = new ArrayList<ArrayList<Integer>>();
        // Call backtracking function to find solutions
        bt(0, n);
        // Return the final result
        return result;
    }
}
