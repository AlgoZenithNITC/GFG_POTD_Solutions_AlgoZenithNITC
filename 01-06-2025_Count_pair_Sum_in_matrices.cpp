class Solution {
  public:
    int countPairs(vector<vector<int>> &mat1, vector<vector<int>> &mat2, int x) {
        // code here
         int count=0;
         int n=mat1.size();
         unordered_set<int> m;
         for(int i=0; i<n; i++){
             for(int j=0; j<n; j++){
                 m.insert(mat2[i][j]);
             }
         }
         for(int i=0; i<n; i++){
             for(int j=0; j<n; j++){
                 if(m.count(x-mat1[i][j])) count++;
             }
         }
    
    return count;
    }
};
