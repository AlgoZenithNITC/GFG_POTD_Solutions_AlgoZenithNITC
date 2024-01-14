class Solution{   
    public:
    vector<int> repeatedRows(vector<vector<int>> &matrix, int M, int N){ 
        unordered_set<int> s;
        vector<int> ans;
        for(int i = 0; i < M; i++){
            int number = 0;
            for(int j = 0; j < N; j++){
                number += (matrix[i][j] << j);
            }
            if(s.find(number) == s.end()){
                s.insert(number);
            }else{
                ans.push_back(i);
            }
        }
        return ans;
    } 
};
