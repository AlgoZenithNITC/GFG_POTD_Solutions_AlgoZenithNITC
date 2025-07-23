class Solution {
  public:
    int subarraySum(vector<int>& arr) {
        // code here
        int n = arr.size();
        int ans=0;
        
        /*for(int i=0; i<n; i++){
            int sum = 0;
            for(int j =i; j<n; j++){
                sum+=arr[j];
                ans+=sum;
            }
        }*/
        int count =0;
        for(int i=0; i<n; i++){
            ans+=(arr[i]*(n-count)*(count+1));
            count++;
        }
        return ans;
    }
};
