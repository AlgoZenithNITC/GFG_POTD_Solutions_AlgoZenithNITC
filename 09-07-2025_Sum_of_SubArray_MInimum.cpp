class Solution {
  public:
    int sumSubMins(vector<int> &arr) {
        // code here
        int n = arr.size();
        vector<long long> dp(n, 0),right(n);
        stack <int> stack;
        for(int i=0;i<n;i++){
            while(!stack.empty() && arr[i]<arr[stack.top()]){
                right[stack.top()]=i;
                stack.pop();
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            right[stack.top()] =n;
            stack.pop();
        }
        dp[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            if(right[i]==n)
                dp[i]=(n-i)*arr[i];
            else
                dp[i]=(right[i]-i)*arr[i]+dp[right[i]];
        }
        return accumulate(dp.begin(),dp.end(),0);
    }
};