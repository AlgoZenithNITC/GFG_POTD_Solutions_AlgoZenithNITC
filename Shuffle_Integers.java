class Solution{
    void shuffleArray(long arr[], int n){
        int m = n/2;
        for(int i = 0; i < m; i++){
            arr[i + m] += arr[i]*1001;
        }
        for(int i = 0; i < m; i++){
            arr[2*i] = arr[i + m]/1001;
            arr[2*i + 1] = arr[i + m]%1001;
        }
    }
}
