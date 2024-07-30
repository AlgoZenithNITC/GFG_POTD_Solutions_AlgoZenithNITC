

class Solution {
    public int[][] visited = new int[5][5]; 
    public ArrayList<String> result =
        new ArrayList<String>(); 

    public void path(int[][] m, int x, int y, String dir, int n) {
        if (x == n - 1 &&
            y == n - 1) {    
            result.add(dir); 
            return;          
        }

        if (m[x][y] == 0 ||
            visited[x][y] == 1) { 
            return;               
        }

        visited[x][y] = 1; 
        if (x > 0) {
            path(m, x - 1, y, dir + 'U',
                 n); 
        }
        if (y > 0) {
            path(m, x, y - 1, dir + 'L',
                 n); 
        }
        if (x < n - 1) {
            path(m, x + 1, y, dir + 'D',
                 n); 
        }
        if (y < n - 1) {
            path(m, x, y + 1, dir + 'R',
                 n); 
        }
        visited[x][y] = 0; 
    }

    public ArrayList<String> findPath(int[][] mat) {
        int n = mat.length;
        result = new ArrayList<>();
        if (mat[0][0] == 0 ||
            mat[n - 1][n - 1] == 0) { 
            return result;            
        }

        path(mat, 0, 0, "", n);   
        Collections.sort(result); 
        return result;            
    }
}
