class Solution{
public:    
    int transitionPoint(int arr[], int n){
        int one_pos = upper_bound(arr, arr + n, 0) - arr;
        if(one_pos >= n){
            return -1;
        }
        return one_pos;
    }
};
