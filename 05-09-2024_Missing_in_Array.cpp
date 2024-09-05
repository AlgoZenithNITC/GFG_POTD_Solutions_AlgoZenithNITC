class Solution {
  public:

    // Note that the size of the array is n-1
    int missingNumber(int n, vector<int>& arr) {
        int totalsum = (long long)((n * (n + 1))/2);
        for(int i = 0; i < n-1; i++){
            totalsum -= arr[i];
        }
        return totalsum;
    }
};
