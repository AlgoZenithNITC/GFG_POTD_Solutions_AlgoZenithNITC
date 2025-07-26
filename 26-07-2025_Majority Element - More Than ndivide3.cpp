class Solution {
  public:
    vector<int> findMajority(vector<int>& arr) {
        // Code here
        int value=arr.size()/3;
       map<int,int>mp;
        for(auto i:arr){
            mp[i]++;
        }
        //cout<<value;
        vector<int>res;
        for(auto&i:mp){
            if(i.second>value){
                res.push_back(i.first);
            }
        }
        return res;
    }
    
};