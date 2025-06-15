class Solution {
  public:
    bool check(vector<int>& arr,int mid,int k)
    {
        int sum=0;
        for( int i:arr)
        {
            sum+=(i+mid-1)/mid;
            if(sum>k)return false;
        }
    
        return true;
    }
    int smallestDivisor(vector<int>& arr, int k) {
        
        // sort(arr.begin(),arr.end());
        if(k==arr.size())return *max_element(arr.begin(), arr.end());
        int left=1;
        int right=*max_element(arr.begin(),arr.end());
        while(left<right){
            int mid=left+(right-left)/2;
            if(check(arr,mid,k))
            {
                right=mid;
            }
            else
            {
                left=mid+1;
            }
        }
        return left;
        
        
    }
};
