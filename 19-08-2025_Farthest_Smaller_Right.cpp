class Solution {
  public:
    vector<int> farMin(vector<int>& arr) {
        // code here
        int n=(int)arr.size();
        
        vector<int>suffix(n+1,INT_MAX);
        
        for(int i=n-1;i>=0;i--)
        {
            suffix[i]=min(suffix[i+1],arr[i]);
        }
        
        vector<int>ans(n,-1);
        for(int i=0;i<n-1;i++)
        {
            int low=i+1;
            int high=n-1;
            int res = -1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                
                if(suffix[mid]<arr[i])
                {
                    res=mid;
                    low=mid+1;
                }
                else
                {
                    high = mid-1;
                }
            }
            ans[i]=res;
        }
        return ans;
        
        
    }
};