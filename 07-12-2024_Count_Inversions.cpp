class Solution {
  private:
    int mergeAndCount(vector<int> &arr, int l, int m, int r){
        int n1 = m-l+1, n2 = r-m, count = 0;
        vector<int> left(n1+1), right(n2+1);
        
        int i = 0, j = 0, k = 0;
        for(i = l, k = 0; i <= m; i++, k++) {left[k] = arr[i];}
        for(j = m+1, k = 0; i <= r; i++, k++) {right[k] = arr[i];}
        left[n1] = right[n2] = INT_MAX;
        
        i = j = 0; k = l;
        while(i < n1 && j < n2){
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
                count += n1-i;
            }
        }
        while(i < n1) {arr[k++] = left[i++];}
        while(j < n2) {arr[k++] = right[j++];}
        return count;
    }
  
    int divideAndCount(vector<int> &arr, int l, int r){
        int count = 0;
        if(l < r){
            int m = (l+r)/2;
            count += divideAndCount(arr,l,m);
            count += divideAndCount(arr,m+1,r);
            count += mergeAndCount(arr,l,m,r);
        }
        return count;
    }
  public:
    // Function to count inversions in the array.
    int inversionCount(vector<int> &arr) {
        return divideAndCount(arr,0,arr.size()-1);
    }
};
