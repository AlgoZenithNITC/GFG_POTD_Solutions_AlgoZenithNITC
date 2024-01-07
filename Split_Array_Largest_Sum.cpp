class Solution {
  public:
    bool check(int mid, int arr[], int n, int K){
        int number = 0, sum = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] > mid){
                return false;
            }
            sum += arr[i];
            if(sum > mid){
                number++;
                sum = arr[i];
            }
        }
        number++;
        if(number <= K){
            return true;
        }
        return false;
    }
    int splitArray(int arr[] ,int N, int K){
        int low = *max_element(arr, arr + N);
        int high = accumulate(arr, arr + N, 0);
        if(K == 1){
            return high;
        }
        if(K == N){
            return low;
        }
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(check(mid, arr, N, K)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
};
