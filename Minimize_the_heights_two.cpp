class Solution{
  public:
    int getMinDiff(int arr[], int n, int k){
        sort(arr, arr + n);
        int ans = arr[n - 1] - arr[0];
        int minimum = arr[0] + k;
        int maximum = arr[n - 1] - k;
        int curr_max, curr_min;
        for(int i = 0; i < n - 1; i++){
            curr_min = min(arr[i + 1] - k, minimum);
            curr_max = max(arr[i] + k, maximum);
            if(curr_min >= 0){
                ans = min(ans, curr_max - curr_min);
            }
        }
        return ans;
    }
};
