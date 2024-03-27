//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution
{
public:
    int findShortestPath(vector<vector<int>> &mat)
    {
       // code here
         int n = mat.size();          // Get the number of rows in the matrix
        int m = mat[0].size();       // Get the number of columns in the matrix
    
        // Create a 2D vector to mark visited cells with initial values of 0
        vector<vector<int>> vis(n, vector<int>(m));
    
        int dx[4] = {-1, 1, 0, 0};  // Define horizontal direction changes
        int dy[4] = {0, 0, -1, 1};  // Define vertical direction changes
    
        // Mark 1's adjacent to 0 as -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < n && ny < m && mat[nx][ny] == 1)
                            mat[nx][ny] = -1;
                    }
                }
            }
        }
    
        queue<pair<int, pair<int, int>>> q;
    
        // Add the starting cells (1's in the first column) to the queue
        for (int i = 0; i < n; i++) {
            if (mat[i][0] == 1) {
                q.push({0, {i, 0}});
                vis[i][0] = 1;
            }
        }
    
        int ans = INT_MAX;  // Initialize the answer variable with a large value
    
        while (!q.empty()) {
            int dist = q.front().first;         // Get the current distance
            int r = q.front().second.first;     // Get the current row
            int c = q.front().second.second;    // Get the current column
            q.pop();
    
            if (c == m - 1)
                ans = min(ans, dist + 1);  // Update the answer if reaching the last column
    
            for (int k = 0; k < 4; k++) {
                int nx = r + dx[k];
                int ny = c + dy[k];
    
                // Check if the new cell is within bounds and is a valid path
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && mat[nx][ny] == 1 && !vis[nx][ny]) {
                    vis[nx][ny] = 1;            // Mark the new cell as visited
                    q.push({dist + 1, {nx, ny}});  // Add the new cell to the queue with an updated distance
                }
            }
        }
    
        return ans == INT_MAX ? -1 : ans;  // Return the answer or -1 if no path is found
}

    
};

//{ Driver Code Starts.

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int R, C;
        cin >> R >> C;
        vector<vector<int>> mat(R, vector<int>(C));
        for (int i = 0; i < R; i++)
        {
            for (int j = 0; j < C; j++)
            {
                cin >> mat[i][j];
            }
        }

        Solution ob;
        int ans = ob.findShortestPath(mat);
        cout << ans << "\n";
    }
    return 0;
}

// } Driver Code Ends