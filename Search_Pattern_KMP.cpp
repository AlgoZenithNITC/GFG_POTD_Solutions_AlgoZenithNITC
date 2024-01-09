vector <int> search(string pat, string txt)
        {
            int first = 0, second = 0;
            vector<int> ans;
            int n = txt.size();
            int m = pat.size();
            for(int i = 0; i <= n-m; i++)
            {
                first = i;
                if(txt[i] == pat[0])
                {
                    string temp = txt.substr(i,m);
                    if(temp == pat)
                    {
                        ans.push_back(i+1);
                    }
                }
            }
            return ans;
            
