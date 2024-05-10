class Solution{
public:

    void help(vector<int> &arr,int n,int k , int i , int sum, vector<int> &target , set<vector<int>> &ans)
    {
        if(sum==k)
        {
            ans.insert(target);
            return;
        }
        if(i==n)
        return;
        help(arr,n,k,i+1,sum,target,ans);
        if(sum+arr[i]<=k)
        {
            target.push_back(arr[i]);
            help(arr,n,k,i+1,sum+arr[i],target,ans);
            target.pop_back();
        }
    }
    vector<vector<int>> CombinationSum2(vector<int> arr,int n,int k)
    {
        sort(arr.begin(),arr.end());
        vector<int> target;
        set<vector<int>> ans;
        help(arr, n , k , 0 , 0 , target , ans);
        vector<vector<int>> result(ans.begin(),ans.end());
        return result;
    }
};
