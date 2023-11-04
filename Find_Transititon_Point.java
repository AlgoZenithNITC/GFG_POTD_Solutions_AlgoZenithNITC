class Solution{
    int transitionPoint(int arr[], int n){
        int one_pos = upperBound(arr, 0, n, 0);
        if (one_pos >= n){
            return -1;
        }
        return one_pos;
    }
    int upperBound(int arr[], int start, int end, int value){
        int index = end;
        while(start < end){
            int mid = start + (end - start)/2;
            if(arr[mid] <= value){
                start = mid + 1;
            }else{
                end = mid;
                index = end;
            }
        }
        return index;
    }
}
