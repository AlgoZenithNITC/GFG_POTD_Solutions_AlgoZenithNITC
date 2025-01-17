class Solution {
  public:
    vector<int> productExceptSelf(vector<int>& arr) {
        int n = arr.size(), prod = 1, zero = 0, ind = 0;
        vector<int> res(n,0);
        for(int i=0; i<n; i++){
            if(!arr[i]){
                zero++;
                ind = i;
            }else{
                prod *= arr[i];
            }
        }
        if(zero == 1){
            res[ind] = prod;
        }else if(zero == 0){
            for(int i=0; i<n; i++){
                res[i] = prod / arr[i];
            }
        }
        return res;
    }
};
