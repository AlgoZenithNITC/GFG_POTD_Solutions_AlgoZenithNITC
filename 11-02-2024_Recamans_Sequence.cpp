// User function Template for C++

class Solution{
public:


    vector<int> recamanSequence(int n){
        // code here
        vector<int> ans(n,0);
        map<int,int> mp;
        ans[0] = 0;
        for(int i = 1; i < n; i++)
        {
            if(ans[i-1] - i > 0)
            {
                if(mp[ans[i-1] - i] == 0)
                {
                    ans[i] = ans[i-1] - i;
                    mp[ans[i]]++;
                }
                else
                {
                    ans[i] = ans[i-1] + i;
                    mp[ans[i]]++;
                }
            }
            else
            {
                ans[i] = ans[i-1] + i;
                mp[ans[i]]++;
            }
        }
        return ans;
    }
};
