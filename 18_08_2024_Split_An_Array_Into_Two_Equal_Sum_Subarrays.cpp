class Solution {
  public:
    bool canSplit(vector<int>& arr) {
       long long total=0;
       for(auto num:arr){
           total+=num;
       }
        long long curr=0;
       for(int i=0;i<arr.size();i++){
           curr+=arr[i];
           if(curr+curr==total) return true;
       }
       return false;
    }
};
