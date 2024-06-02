class Solution {
  public:
    vector<int> constructList(int k, vector<vector<int>> &q) {
        vector<int> ans;
        int x = 0;
        ans.push_back(0);
        for(int i = 0 ; i<q.size() ; i++)
        {
            if(q[i][0]==0)
            {
                ans.push_back(q[i][1]^x);
            }
            else
            {
                x ^= q[i][1];
            }
        }
        for(int j = 0 ; j < ans.size() ; j++)
        {
            ans[j] ^= x;
        }
        sort(ans.begin(),ans.end());
        return ans;
    }
};
