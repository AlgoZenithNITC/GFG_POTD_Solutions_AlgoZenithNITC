class Solution {
  public:
    int countSubarrays(vector<int> &arr, int k) {
        unordered_map<int, int> prefixSums;
        int res = 0;
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) 
        {
            sum += arr[i];
            if (sum == k)
            {
                res++;
            }
            if (prefixSums.find(sum - k) != prefixSums.end())
            {
                res += prefixSums[sum - k];
            }
            prefixSums[sum]++;
        }
        return res;
    }
};