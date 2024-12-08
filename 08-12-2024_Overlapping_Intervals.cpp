class Solution {
  public:
    vector<vector<int>> mergeOverlap(vector<vector<int>>& arr) {
        sort(arr.begin(),arr.end());
        
        int n=arr.size();
        vector<vector<int>> res;
        int i=0;
        while(i<n){
            vector<int> tem(2,0);
            tem[0]=arr[i][0];
            tem[1]=arr[i][1];
            while(i+1<n && tem[1]>=arr[i+1][0]){
                tem[1]=max(tem[1],arr[i+1][1]);
                i++;
            }
            res.push_back(tem);
            i++;
        }
        return res;
        
    }
};