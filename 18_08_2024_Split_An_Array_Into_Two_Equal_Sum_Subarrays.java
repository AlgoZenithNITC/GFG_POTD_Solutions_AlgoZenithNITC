

class Solution {
    public boolean canSplit(int arr[]) {
        // code here
        int n = arr.length;
        if(n==1){
            return false;
        }
        int sum = 0;
        int leftSum = 0, rightSum = 0;
        for(int j = n-1; j >= 0; j--){
            rightSum += arr[j];
        }
        for(int i = 0; i < n; i++){
            leftSum += arr[i];
            rightSum -= arr[i];
            if(leftSum == rightSum){
                return true;
            }
        }
        return false;
    }
}
