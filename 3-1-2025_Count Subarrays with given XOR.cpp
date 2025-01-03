class Solution {
    public long subarrayXor(int arr[], int k) {
        int res = 0; 
    for (int i = 0; i < arr.size(); i++) {
        int prefXOR = 0; 
        for (int j = i; j < arr.size(); j++) {
            prefXOR = prefXOR ^ arr[j];
            if (prefXOR == k)
                res++;
        }
    }
    return res;
    }