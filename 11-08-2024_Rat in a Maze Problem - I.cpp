//Back-end complete function template for C++

// Creating a 2D vector to keep track of visited cells
vector<vector<int>> visited(5, vector<int>(5, 0));

// Creating a vector to store the result paths
vector<string> result;

class Solution {
  public:
    // Function to find the path
    void path(vector<vector<int>> &m, int x, int y, string dir, int n) {
        // If the current cell is the destination, add the direction to the result
        // vector
        if (x == n - 1 and y == n - 1) {
            result.push_back(dir);
            return;
        }

        // If the current cell is blocked or already visited, return
        if (m[x][y] == 0 or visited[x][y] == 1)
            return;

        // DFS traversal
        // Marking the current cell as visited
        visited[x][y] = 1;

        // Recursively calling the path function for the adjacent cells in all possible
        // directions
        if (x > 0)
            path(m, x - 1, y, dir + 'U', n);
        if (y > 0)
            path(m, x, y - 1, dir + 'L', n);
        if (x < n - 1)
            path(m, x + 1, y, dir + 'D', n);
        if (y < n - 1)
            path(m, x, y + 1, dir + 'R', n);

        // Marking the current cell as not visited
        visited[x][y] = 0;
    }

    // Function to find all possible paths
    vector<string> findPath(vector<vector<int>> &mat) {
        int n = mat.size();
        // Resetting the visited cells and result vector
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
        result.clear();

        // If the source or destination cell is blocked, return empty result vector
        if (mat[0][0] == 0 || mat[n - 1][n - 1] == 0)
            return result;

        // Finding all possible paths
        path(mat, 0, 0, "", n);

        // Sorting the result vector in lexicographical order
        sort(result.begin(), result.end());

        // Returning the result vector
        return result;
    }
};
