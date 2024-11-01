class Solution {
  public:
    long long maxSum(vector<int>& arr) {
        
        sort(arr.begin(),arr.end());
        
        vector<int> final;
        
        int start=0;
        int end = arr.size()-1;
        
        while(start<=end)
        {
            final.push_back(arr[start]);
            final.push_back(arr[end]);
            start++;
            end--;
        }
        
        long long int sum = 0;
        
        for(int i=0;i<final.size()-1;i++)
        {
            sum+=abs(final[i+1]-final[i]);
        }
        
        int lastindex=final.size()-1;
        
        sum+=abs(final[0]-final[lastindex]);
        
        
        return sum;
    }
    
};
