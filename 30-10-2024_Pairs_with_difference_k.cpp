class Solution {
  public:
    /* Returns count of pairs with difference k  */
    int countPairsWithDiffK(vector<int>& arr, int k) {
        int maxi = 0;
        int size = arr.size(), count=0;
        for(int i=0;i<size;i++){
            if(arr[i] > maxi)
                maxi = arr[i];
        }
        int ht[maxi+1] = {0};
        for(int i=0;i<size;i++) ht[arr[i]]++;
        for(int i=0;i<size;i++){
            int curr = arr[i];
            if((curr + k <= maxi) && ht[curr + k]){
                count += ht[curr + k];
            }
        }
        return count;
    }
};
