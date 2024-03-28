// User function Template for C++

class Solution {
public:
    int findCity(int n, int m, vector<vector<int>>& edges, int distanceThreshold) {
        vector<vector<int>> mat(n,vector<int>(n, INT_MAX)); 
        for(int i = 0; i < n; i++) {
            mat[i][i] = 0;
        }

       
        for(int i = 0; i < m; i++) {
            int r = edges[i][0];
            int c = edges[i][1];
            int w = edges[i][2];
            mat[r][c] = w;
            mat[c][r] = w;
        }

       
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(mat[i][k] != INT_MAX && mat[k][j] != INT_MAX) {
                        mat[i][j] = min(mat[i][j], mat[i][k] + mat[k][j]);
                    }
                }
            }
        }

        int min_city = INT_MAX;
        int city = INT_MAX;
       
        for(int i = 0; i < n; i++) {
            int c = 0;
            for(int j = 0; j < n; j++) {
                if(mat[i][j] > 0 && mat[i][j] <= distanceThreshold) {
                    c++;
                }
            }
            if(c <= min_city) {
                min_city = c;
                city = i;
            }
        }
        return city;
    }
};
