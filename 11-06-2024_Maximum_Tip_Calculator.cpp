class Solution {
  public:
    long long maxTip(int n, int x, int y, vector<int> &arr, vector<int> &brr) {
        vector<pair<int,pair<int,int>>> dp;
        
        for(int i=0;i<arr.size();i++){
            dp.push_back({abs(arr[i]-brr[i]), {arr[i], brr[i]}});
        }
        
        sort(dp.rbegin(), dp.rend());
        
        long long ans=0;
        for(int i=0;i<dp.size();i++){
            if(x==0){
                ans+=dp[i].second.second;
            }
            else if(y==0){
                ans+=dp[i].second.first;
            }
            else{
                if(dp[i].second.first > dp[i].second.second){
                    x--;
                    ans+=dp[i].second.first;
                }
                else{
                    y--;
                    ans+=dp[i].second.second;
                }
            }
        }
        return ans;
    }
};
