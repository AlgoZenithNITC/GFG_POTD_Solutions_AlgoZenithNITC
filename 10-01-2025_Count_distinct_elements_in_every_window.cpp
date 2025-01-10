class Solution {
  public:
    vector<int> countDistinct(vector<int> &arr, int k) {
        // code here.
        vector <int> ans;
        unordered_map <int,int> hash;
        int n=arr.size();
        int c=0;
        for(int i=0;i<k;i++){
            if(hash[arr[i]]==0){
                c++;
            }
            hash[arr[i]]++;
            
        }
        ans.push_back(c);
        for(int i=k;i<n;i++){
            if(hash[arr[i-k]]==1){
                c--;
            }
            hash[arr[i-k]]--;
            if(hash[arr[i]]==0){
                c++;
            }
            hash[arr[i]]++;
            ans.push_back(c);
        }
        return ans;
    }
};