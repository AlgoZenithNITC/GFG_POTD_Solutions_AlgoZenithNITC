class Solution {
  public:
    int threeSumClosest(vector<int> arr, int target) {
        
        int dif=INT_MAX,ans=INT_MIN;
        sort(arr.begin(),arr.end());
        for(int i=0;i<arr.size();i++){
            int start=i+1;
            int end=arr.size()-1;
            while(start<end){
                int sum=arr[i]+arr[start]+arr[end];
                if(sum==target)return sum;
                else if(sum>target) end--;
                else start++;
                if(abs(sum-target)<dif){
                    dif=abs(sum-target);
                    ans=sum;
                }
                else if(abs(sum-target)==dif){
                    ans=max(ans,sum);
                }
            }
        }
        return ans;
    }
};
