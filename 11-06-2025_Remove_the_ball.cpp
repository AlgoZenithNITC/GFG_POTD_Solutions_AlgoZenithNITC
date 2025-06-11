class Solution {
  public:
    int findLength(vector<int> &color, vector<int> &radius)
    {
        int n=color.size();
        int ans=0;
        int i=0;
        
        stack<pair<int,int>> s;
        
        for(;i<n;++i)
        {
            pair<int,int> curr={color[i],radius[i]};
            if(!s.empty() && s.top()==curr)
                s.pop();
            else
                s.push(curr);
        }
        return s.size();
    }
};