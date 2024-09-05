class Solution {

    // Note that the size of the array is n-1
    int missingNumber(int n, int arr[]) {
        int totalsum = (n * (n+1))/2;
        for(int i = 0; i < n-1; i++){
            totalsum -= arr[i];
        }
        return totalsum;
    }
}
