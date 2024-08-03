class Solution {
    // Function to find if there is a celebrity in the party or not.
    int celebrity(int Mat[][], int N) {
        // code here
        int[] indegree = new int[N];
        int[] outdegree = new int[N];

        // Query for all edges
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int x = Mat[i][j];

                // Set the degrees
                outdegree[i] += x;
                indegree[j] += x;
            }
        }

        // Find a person with indegree N-1 and outdegree 0
        for (int i = 0; i < N; i++) {
            if (indegree[i] == N - 1 && outdegree[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}
