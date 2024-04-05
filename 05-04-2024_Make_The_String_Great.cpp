class Solution {
public:
    string makeGood(string s) {
        int n=s.length();
        string ans="";
        for(int i=0;i<n;i++)
        {
            if(ans.empty())
            {
                ans.push_back(s[i]);
            }
            else if(!ans.empty()&&ans.back()!=s[i]&&tolower(ans.back())==tolower(s[i]))
            {
                ans.pop_back();
            }
            else
            {
                ans.push_back(s[i]);
            }
        }
        return ans;
    }
};
