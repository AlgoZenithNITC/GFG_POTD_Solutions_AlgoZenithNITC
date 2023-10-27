class Solution{
  public:
    int LCS(string first, string second){
        int n = first.length();
        vector<int> prev(n + 1);
        for(int i = 1; i <= n; i++){
            vector<int> curr(n + 1);
            for(int j = 1; j <= n; j++){
                if(first[i - 1] == second[j - 1]){
                    curr[j] = 1 + prev[j - 1];
                }else{
                    int left = curr[j - 1];
                    int top = prev[j];
                    curr[j] = max(left, top);
                }
            }
            prev = curr;
        }
        return prev[n];
    }
    int minimumNumberOfDeletions(string S){ 
        string first = S;
        reverse(S.begin(), S.end());
        string second = S;
        return S.length() - LCS(first, second);
    } 
};
