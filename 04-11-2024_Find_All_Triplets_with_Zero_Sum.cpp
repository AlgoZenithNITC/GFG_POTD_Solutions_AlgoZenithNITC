class Solution {
  public:
    vector<vector<int>> findTriplets(vector<int> &arr) {
        vector<vector<int>> v; 
        for(int i=0; i<arr.size(); i++){
            for(int j=i+1; j<arr.size(); j++){
                for(int k=j+1; k<arr.size(); k++){
                    if (arr[i]+arr[j]+arr[k] == 0){
                        v.push_back({i,j,k});
                    }
                }
            }
        }
        return v;
    }
};