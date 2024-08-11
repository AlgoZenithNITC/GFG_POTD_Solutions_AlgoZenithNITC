//Back-end complete function Template for Java

class Solution {
    public int[][] visited = new int[5][5]; // 2D array to keep track of visited cells
    public ArrayList<String> result =
        new ArrayList<String>(); // ArrayList to store the path results

    public void path(int[][] m, int x, int y, String dir, int n) {
        if (x == n - 1 &&
            y == n - 1) {    // if we reached the bottom-right corner of the matrix
            result.add(dir); // add the current direction to the path list
            return;          // exit the recursive function
        }

        if (m[x][y] == 0 ||
            visited[x][y] == 1) { // if the current cell is blocked or already visited
            return;               // exit the recursive function
        }

        visited[x][y] = 1; // mark the current cell as visited
        if (x > 0) {
            path(m, x - 1, y, dir + 'U',
                 n); // recursively call the path function for the cell above
        }
        if (y > 0) {
            path(m, x, y - 1, dir + 'L',
                 n); // recursively call the path function for the cell on the left
        }
        if (x < n - 1) {
            path(m, x + 1, y, dir + 'D',
                 n); // recursively call the path function for the cell below
        }
        if (y < n - 1) {
            path(m, x, y + 1, dir + 'R',
                 n); // recursively call the path function for the cell on the right
        }
        visited[x][y] = 0; // mark the current cell as unvisited after backtracking
    }

    public ArrayList<String> findPath(int[][] mat) {
        int n = mat.length;
        result = new ArrayList<>();
        if (mat[0][0] == 0 ||
            mat[n - 1][n - 1] == 0) { // if the top-left or bottom-right cell is blocked
            return result;            // return an empty result list
        }

        path(mat, 0, 0, "", n);   // start finding paths from the top-left cell
        Collections.sort(result); // sort the result list lexicographically
        return result;            // return the sorted result list
    }
}
