class Solution
{
    public:
       vector <int> search(string pattern, string text)
       {
            vector<int> ans;
            int m=pattern.size();
            int n=text.size();
            for(int i=0;i<=n-m;i++){
                if( pattern == text.substr(i,m) ){
                    ans.push_back(i+1);
                }
            }
            return ans;
        }
};
