class Solution {
  public:
    int longestCommonSum(vector<int> &a1, vector<int> &a2) {
        // Code here.
        int n=a1.size(),ans=0;
        unordered_map <int,int>mp;
        mp[0]=-1;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=(a1[i]-a2[i]);
            if(mp.find(sum)!=mp.end())
                ans=max(ans,i-mp[sum]);
            else
            mp[sum]=i;
        }
        return ans;
    }
};