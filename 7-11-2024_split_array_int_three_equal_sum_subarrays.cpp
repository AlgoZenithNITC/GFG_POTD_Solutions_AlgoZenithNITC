class Solution {
  public:
  
  int findSum(vector<int> &arr, int start, int end) {
    int sum = 0;
    for(int i = start; i <= end; i++) 
        sum += arr[i];
    return sum;
  } 

    // Function to determine if array arr can be split into three equal sum sets.
    vector<int> findSplit(vector<int>& arr) {
        // code here
         int n = arr.size();
  
    // First partition
    for(int i = 0; i < n - 2; i++) {
        
        // Second Partition
        for(int j = i + 1; j < n - 1; j++) {
            
            // Find sum of all three segments
            int sum1 = findSum(arr, 0, i);
            int sum2 = findSum(arr, i + 1, j);
            int sum3 = findSum(arr, j + 1, n - 1);
            
            // If all three segments have equal sum,
            // then return true
            if(sum1 == sum2 && sum2 == sum3)
                return {i, j};
        }
    }
  
    // No possible index pair found
    return {-1, -1};
    }
};

