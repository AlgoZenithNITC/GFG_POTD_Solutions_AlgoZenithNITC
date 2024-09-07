class Solution {
  public:
    // Function to find the sum of contiguous subarray with maximum sum.
    long long maxSubarraySum(vector<int> &arr) {
        // code here...
        long long max_so_far = -1e12, max_ending_here = 0;

        for (int i = 0; i < arr.size(); i++) {      
            max_ending_here = max_ending_here + arr[i];
          
            // If max_ending_here becomes more than 
            // the current result
            max_so_far = max(max_so_far, max_ending_here);
           
            // If max_ending_here becomes negative
            max_ending_here = max(max_ending_here, 0LL);
        }
        
        return max_so_far;
        
    }
};
