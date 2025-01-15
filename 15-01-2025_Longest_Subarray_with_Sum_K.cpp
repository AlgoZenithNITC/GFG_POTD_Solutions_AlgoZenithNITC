class Solution {
  public:
    int longestSubarray(vector<int>& arr, int k) 
    {
        int n = arr.size();
    
        unordered_map <int,int> mp ;
        
        int ans = 0;
        
        int psum =0;
        
        for(int i=0;i<n;i++)
        {
            psum+=arr[i];
            
            if(psum == k)
            {
                ans = i+1;
            }
            
            
            if(mp.find(psum - k)!=mp.end())
            {
                ans = max(ans,i - mp[psum-k]);
            }
            
            if(mp.find(psum)==mp.end())
            {
                mp[psum]=i;
            }
        }
        
        
        return ans;
        
     
    }
};
