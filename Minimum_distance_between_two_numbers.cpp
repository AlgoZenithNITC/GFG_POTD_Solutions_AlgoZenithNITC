class Solution{
  public:
    int minDist(int a[], int n, int x, int y){
        int ans = INT_MAX, left = -1, right = -1;
        for(int i = 0; i < n; i++){
            if(a[i] == x){
                left = i;
            }
            if(a[i] == y){
                right = i;
            }
            if(left != -1 and right != -1){
                ans = min(ans, abs(left - right));
            }
        }
        return ans == INT_MAX ? -1 : ans;
    }
};
