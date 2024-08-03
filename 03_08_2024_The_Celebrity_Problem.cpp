class Solution {
public:
    // Function to find if there is a celebrity in the party
    // or not.

    int celebrity(vector<vector<int> >& Mat, int N)
    {
        // code here
        int indegree[N] = { 0 }, outdegree[N] = { 0 };

        // query for all edges
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int x = Mat[i][j];

                // set the degrees
                outdegree[i] += x;
                indegree[j] += x;
            }
        }

        // find a person with indegree n-1
        // and out degree 0
        for (int i = 0; i < N; i++)
            if (indegree[i] == N - 1 && outdegree[i] == 0)
                return i;

        return -1;
    }
};
