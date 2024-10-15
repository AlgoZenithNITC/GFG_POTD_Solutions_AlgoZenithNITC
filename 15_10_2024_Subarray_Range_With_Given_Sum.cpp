class Solution {
  public:
    // Function to count the number of subarrays which adds to the given sum.
    int subArraySum(vector<int>& arr, int tar) {
        // Your code here
        int n = arr.size();
        unordered_map<int, int> summap;
        int sum = 0;
        int count = 0;
        summap[0] = 1;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            int rem=sum - tar;
            count += summap[rem];
            summap[sum]+=1;
        }
        return count;
    }
};
