class Solution {
  public:
    int singleElement(int arr[] ,int N){
        vector<int> count(32, 0);
        for(int bit = 0; bit < 32; bit++){
            for(int i = 0; i < N; i++){
                if(arr[i]&(1<<bit)){
                    count[bit]++;
                }
            }
        }
        int ans = 0;
        for(int bit = 0; bit < 32; bit++){
            if(count[bit]%3 != 0){
                ans += (1 << bit);
            }
        }
        return ans;
    }
};
