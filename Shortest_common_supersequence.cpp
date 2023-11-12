class Solution{
    public:
    int shortestCommonSupersequence(string X, string Y, int m, int n){
        vector<int> prev(n + 1, 0), curr(n + 1, 0);
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(X[i - 1] == Y[j - 1]){
                    curr[j] = 1 + prev[j - 1];
                }else{
                    curr[j] = max(curr[j - 1], prev[j]);
                }
            }
            prev = curr;
        }
        int lcs = curr[n];
        return n + m - lcs;
    }
};
